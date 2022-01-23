package dev.matyaqubov.modul4lesson06kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.ImageForGrid
import dev.matyaqubov.modul4lesson06kotlin.adapter.CustomSecondAdapter
import androidx.recyclerview.widget.GridLayoutManager

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageForGrids:ArrayList<ImageForGrid>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        fillImages()
        recyclerView=findViewById(R.id.rv_secondActivity)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = CustomSecondAdapter(this, imageForGrids)
        recyclerView.adapter = adapter
    }

    private fun fillImages() {
        imageForGrids = ArrayList()
        for (i in 0..19) {
            imageForGrids.add(ImageForGrid("$i image", R.drawable.image))
        }
    }
}