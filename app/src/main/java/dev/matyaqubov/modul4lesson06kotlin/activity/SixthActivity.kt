package dev.matyaqubov.modul4lesson06kotlin.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.Image
import dev.matyaqubov.modul4lesson06kotlin.model.SubImage
import androidx.recyclerview.widget.GridLayoutManager
import dev.matyaqubov.modul4lesson06kotlin.adapter.CustomRecyclerViewAdapterWithIncidable

class SixthActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    private lateinit var images:ArrayList<Image>
    private lateinit var subImages:ArrayList<SubImage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)
        initViews()
    }

    private fun initViews() {
        context=this
        recyclerView=findViewById(R.id.rv_sixth)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        refreshAdapter()
    }
    private fun refreshAdapter() {
        fillrraylist()
        val adapter = CustomRecyclerViewAdapterWithIncidable(context, images)
        recyclerView.adapter = adapter
    }

    private fun fillrraylist() {
        images = ArrayList()
        fillSubImage()
        for (i in 0..14) {
            images.add(Image(subImages))
        }
    }

    private fun fillSubImage() {
        subImages = ArrayList()
        for (i in 0..9) {
            subImages.add(SubImage("$i-rasm", R.drawable.image))
        }
    }
}