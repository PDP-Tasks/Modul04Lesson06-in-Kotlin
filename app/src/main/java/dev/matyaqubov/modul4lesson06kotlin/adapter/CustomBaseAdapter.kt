package dev.matyaqubov.modul4lesson06kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import dev.matyaqubov.modul4lesson06kotlin.R

class CustomBaseAdapter: BaseAdapter {

    var imagesDesc: Array<String?>
    var imagesPhoto: IntArray
    var context: Context? = null
    var layoutInflater: LayoutInflater? = null

    constructor(imagesDesc: Array<String?>, imagesPhoto: IntArray, context: Context) {
        this.imagesDesc = imagesDesc
        this.imagesPhoto = imagesPhoto
        this.context = context
        this.layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

   override fun getCount(): Int {
        return imagesPhoto.size
    }

   override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        var view = view
        if (view == null) {
            view = layoutInflater!!.inflate(R.layout.item_gallery, viewGroup, false)
        }
        val textView = view!!.findViewById<TextView>(R.id.tv_desc)
        val imageView = view.findViewById<ImageView>(R.id.img_gallery)
        textView.text = imagesDesc[i]
        imageView.setImageResource(imagesPhoto[i])
        return view
    }
}
