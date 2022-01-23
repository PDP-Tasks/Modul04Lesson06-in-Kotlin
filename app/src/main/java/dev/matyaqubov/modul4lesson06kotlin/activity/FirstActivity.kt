package dev.matyaqubov.modul4lesson06kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.adapter.CustomBaseAdapter

class FirstActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    lateinit var descs: Array<String?>
    lateinit var images: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initView()
    }

    private fun initView() {
        gridView = findViewById(R.id.gridview)
        addImageDesc()
        val adapter = CustomBaseAdapter(descs, images, this)
        gridView.adapter=adapter
        gridView.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            doSomething(i)
        })
    }

    private fun doSomething(i: Int) {
        Toast.makeText(this, "image : " + images[i] + " desc : " + descs[i], Toast.LENGTH_SHORT)
            .show()
    }

    private fun addImageDesc() {
        descs = arrayOfNulls(20)
        images = IntArray(20)
        for (i in 0..19) {
            descs[i] = "$i - rasm"
            images[i] = R.drawable.image
        }
    }
}