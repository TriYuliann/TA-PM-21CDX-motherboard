package com.uti.tipala

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.image)
        val rvImage:TextView = itemView.findViewById(R.id.title)
    }

}