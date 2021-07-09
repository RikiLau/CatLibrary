package com.ddxz.catlibrary.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddxz.catlibrary.R
import com.ddxz.catlibrary.bean.Cat
import com.ddxz.catlibrary.util.getDisplayWidth
import kotlin.math.roundToInt

class CatViewHolder(val parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
                                                      ) {

    private val tvName = itemView.findViewById<TextView>(R.id.tvName)
    private val ivCat = itemView.findViewById<ImageView>(R.id.ivCat)

    fun bind(item: Cat?) {
        tvName.text = item?.name
        Glide.with(parent.context)
                .load(item?.image?.url)
                .into(ivCat)

        val lp = ivCat.layoutParams as FrameLayout.LayoutParams
        item?.image?.let {
            val width = getDisplayWidth(parent.context) - parent.context.resources.getDimension(R.dimen.dp_24)
            lp.height = (ivCat.width.toFloat() / it.width * it.height).roundToInt()
            ivCat.layoutParams = lp
        }
    }
}