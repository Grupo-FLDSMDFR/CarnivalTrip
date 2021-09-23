package com.example.carnivaltrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_list_poi.view.*

class PoiAdapter(val listpoi:List<ListPoi>):RecyclerView.Adapter<PoiAdapter.PoiHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoiHolder(layoutInflater.inflate(R.layout.items_list_poi, parent,false))
    }

    override fun onBindViewHolder(holder: PoiHolder, position: Int) {
        holder.render(listpoi[position])

    }

    override fun getItemCount(): Int = listpoi.size

    class PoiHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(listpoi: ListPoi){
            view.item_title.text = listpoi.titleItem
            view.item_obs.text = listpoi.obsItem
            view.item_quality.text = listpoi.quality
            Picasso.get().load(listpoi.image).into(view.item_img)
            view.setOnClickListener{
                view.findNavController().navigate(R.id.action_viewListPoi_to_viewDetailPoi)
            }
        }
    }

}