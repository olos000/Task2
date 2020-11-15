package org.andronitysolo.task2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.andronitysolo.task2.ListView
import org.andronitysolo.task2.Model.Makanan
import org.andronitysolo.task2.R

class ListAdapter(data1: ListView, private val data: ArrayList<Makanan>) : BaseAdapter() {
    override fun getCount(): Int = data.size ?: 0

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        val foto = view.findViewById<ImageView>(R.id.img_photo)
        val nama = view.findViewById<TextView>(R.id.txt_name)
        val deskripsi = view.findViewById<TextView>(R.id.txt_deskripsi)

        val item = data?.get(position)

        foto.setImageResource((item?.photo ?: 0) as Int)
        nama.text = item.name
        deskripsi.text = item.description

        return view
    }
}