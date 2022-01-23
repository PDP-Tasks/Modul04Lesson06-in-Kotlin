package dev.matyaqubov.modul4lesson06kotlin.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.adapter.MemberRecyclerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import dev.matyaqubov.modul4lesson06kotlin.model.Member

class FourthActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context
    private lateinit var members:ArrayList<Member>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        initView()
    }
    fun initView(){
        context=this
        recyclerView=findViewById(R.id.rv_fourth)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        fillArraylist()
        val adapter = MemberRecyclerAdapter(this, members)
        recyclerView.adapter = adapter
    }

    private fun fillArraylist() {
        members = ArrayList()
        for (i in 0..6) {
            members.add(Member("Alisher", "+998942344432"))
            members.add(Member("Bogibek", "+998975259712"))
            members.add(Member("Ogabek", "+998997492581"))
        }
    }

    fun openDetailActivity(member: Member?) {
        val intent = Intent(this@FourthActivity, DetailActivity::class.java)
        intent.putExtra("member", member)
        startActivity(intent)
    }
}