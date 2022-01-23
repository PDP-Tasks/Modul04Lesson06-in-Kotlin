package dev.matyaqubov.modul4lesson06kotlin.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matyaqubov.modul4lesson06kotlin.R
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.model.MultipleMember
import androidx.recyclerview.widget.GridLayoutManager

import dev.matyaqubov.modul4lesson06kotlin.adapter.CustomMultipleAdapter

class FifthActivity : AppCompatActivity() {

    lateinit var members: ArrayList<MultipleMember>
    lateinit var context: Context
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        initViews()
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.rv_fifth)
        recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        refreshAdapter()
    }

    private fun refreshAdapter() {
        fillArrayList()
        val adapter = CustomMultipleAdapter(context, members)
        recyclerView.adapter = adapter
    }

    private fun fillArrayList() {
        members = ArrayList()
        for (i in 0..22) {
            if (i % 3 == 1) {
                members.add(MultipleMember("Alisher", "+998942344432", false))
            } else {
                members.add(MultipleMember("Alisher", "+998942344432", true))
            }
        }
    }
}