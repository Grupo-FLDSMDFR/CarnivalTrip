package com.example.carnivaltrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.carnival_list_item.view.*

class CarnivalAdapter(private val mCarnival:List<Carnival>):RecyclerView.Adapter<CarnivalAdapter.PoiHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoiHolder(layoutInflater.inflate(R.layout.carnival_list_item, parent,false))
    }

    override fun onBindViewHolder(holder: PoiHolder, position: Int) {
        holder.render(mCarnival[position])
    }

    override fun getItemCount(): Int = mCarnival.size

    class PoiHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(mCarnival: Carnival){
            view.item_title.text = mCarnival.titleItem
            view.item_obs.text = mCarnival.obsItem
            view.item_quality.text = mCarnival.quality
            Picasso.get().load(mCarnival.image).into(view.item_img)
        }
    }

}