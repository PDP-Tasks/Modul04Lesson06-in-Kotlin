package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul4lesson06kotlin.R
import dev.matyaqubov.modul4lesson06kotlin.model.SubImage
import java.util.ArrayList

class SubRecyclerViewAdapter(val context: Context, val subImages: ArrayList<SubImage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_images,parent,false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val subImage=subImages[position]
        if (holder is ImageViewHolder){
            holder.imageView.setImageResource(subImage.photo)
            holder.textViewDesc.text=subImage.desc
        }
    }

    override fun getItemCount(): Int {
        return subImages.size
    }

    class ImageViewHolder(val view :View) :RecyclerView.ViewHolder(view){
        val textViewDesc=view.findViewById<TextView>(R.id.tv_desc);
        val imageView=view.findViewById<ImageView>(R.id.img_gallery);
    }
}