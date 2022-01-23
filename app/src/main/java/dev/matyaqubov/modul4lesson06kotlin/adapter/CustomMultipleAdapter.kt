package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.MultipleMember

class CustomMultipleAdapter(
    private var context: Context, private var members: ArrayList<MultipleMember>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ONLINE = 0
    private val TYPE_OFFLINE = 1


    override fun getItemViewType(position: Int): Int {
        val member = members[position]
        return if (member.isOnline) {
            TYPE_ONLINE
        } else TYPE_OFFLINE

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_OFFLINE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_member_offline, parent, false)
            return OfflineViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return OnlineViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member=members[position]
        if (holder is OnlineViewHolder) {
            holder.textViewPhone.text=member.phone
            holder.textViewUsername.text=member.username
        }
        if (holder is OfflineViewHolder) {
            holder.textViewPhone.text=member.phone
            holder.textViewUsername.text=member.username
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class OnlineViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var textViewUsername = view.findViewById<TextView>(R.id.tv_name)
        var textViewPhone = view.findViewById<TextView>(R.id.tv_phone)
    }

    class OfflineViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var textViewUsername = view.findViewById<TextView>(R.id.tv_name)
        var textViewPhone = view.findViewById<TextView>(R.id.tv_phone)
    }
}