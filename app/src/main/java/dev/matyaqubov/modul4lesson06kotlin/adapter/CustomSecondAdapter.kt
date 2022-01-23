package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R

import dev.matyaqubov.modul4lesson06kotlin.model.ImageForGrid

class CustomSecondAdapter(val context: Context,val imageForGrids:ArrayList<ImageForGrid>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_images,parent,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val imageForGrid=imageForGrids[position]
        if (holder is GridViewHolder){
            holder.imageView.setImageResource(imageForGrid.photo)
            holder.textViewDesc.text=imageForGrid.desc
        }
    }

    override fun getItemCount(): Int {
        return imageForGrids.size
    }

    class GridViewHolder(val view : View) :RecyclerView.ViewHolder(view){
        val textViewDesc=view.findViewById<TextView>(R.id.tv_desc);
        val imageView=view.findViewById<ImageView>(R.id.img_gallery);
    }
}