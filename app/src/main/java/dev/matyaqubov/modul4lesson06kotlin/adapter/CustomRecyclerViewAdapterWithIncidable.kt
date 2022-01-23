package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.Image


import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matyaqubov.modul4lesson06kotlin.model.SubImage


class CustomRecyclerViewAdapterWithIncidable(
    private var context: Context, private var images: ArrayList<Image>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListViewHolder) {
            val rv = holder.recyclerView
            rv.layoutManager = GridLayoutManager(context, 1,LinearLayoutManager.HORIZONTAL,false )
            val subImages = images[position].subImages
            refreshAdapter(rv,subImages)
        }
    }

    private fun refreshAdapter(rv: RecyclerView, subImages: java.util.ArrayList<SubImage>) {
        val adapter = SubRecyclerViewAdapter(context, subImages)
        rv.adapter = adapter
    }

    override fun getItemCount(): Int {
        return images.size
    }


    class ListViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView = view.findViewById<RecyclerView>(R.id.rv_sub)
    }

}