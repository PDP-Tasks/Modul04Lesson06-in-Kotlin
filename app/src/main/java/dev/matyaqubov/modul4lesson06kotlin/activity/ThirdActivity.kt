package dev.matyaqubov.modul4lesson06kotlin.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.ImageForGrid
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import dev.matyaqubov.modul4lesson06kotlin.adapter.NestedRecyclerViewAdapter


class ThirdActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context
    private lateinit var imageForGrids:ArrayList<ImageForGrid>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        initVIews()
    }

    private fun initVIews() {
        context=this
        recyclerView=findViewById(R.id.rv_third)
        fillArrayList()
        val adapter = NestedRecyclerViewAdapter(this, imageForGrids)
        recyclerView.layoutManager =
            GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun fillArrayList() {
        imageForGrids = ArrayList()
        for (i in 0..14) {
            imageForGrids.add(ImageForGrid("$i-rasm", R.drawable.image))
        }
    }
}