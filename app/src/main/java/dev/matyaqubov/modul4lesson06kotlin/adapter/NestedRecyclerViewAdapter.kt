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


class NestedRecyclerViewAdapter (val context: Context, val imageForGrids:ArrayList<ImageForGrid>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_images,parent,false)
        return CustomSecondAdapter.GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val imageForGrid=imageForGrids[position]
        if (holder is MyViewHolder){
            holder.imageView.setImageResource(imageForGrid.photo)
            holder.textView.text=imageForGrid.desc
        }
    }

    override fun getItemCount(): Int {
        return imageForGrids.size
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView=view.findViewById(R.id.img_gallery)
        var textView: TextView=view.findViewById(R.id.tv_desc)
    }
}