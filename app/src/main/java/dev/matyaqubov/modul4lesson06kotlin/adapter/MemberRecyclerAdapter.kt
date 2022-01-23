package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.activity.FourthActivity
import dev.matyaqubov.modul4lesson06kotlin.model.Member

class MemberRecyclerAdapter(val context: FourthActivity,var members:ArrayList<Member>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_member,parent,false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member=members[position]
        if (holder is MemberViewHolder){
            holder.tv_name.text=member.name
            holder.tv_phoneNumber.text=member.phoneNumber
            holder.linearLayoutMember.setOnClickListener {
                context.openDetailActivity(member)
            }
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }

    class MemberViewHolder(val view:View) :RecyclerView.ViewHolder(view){
        var linearLayoutMember=view.findViewById<LinearLayout>(R.id.ll_member)
        val tv_name=view.findViewById<TextView>(R.id.tv_name)
        val tv_phoneNumber=view.findViewById<TextView>(R.id.tv_phone)
    }
}