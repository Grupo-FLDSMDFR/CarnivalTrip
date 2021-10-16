package com.example.carnivaltrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_list_poi.view.*

class PoiAdapter(private val mCarnival: List<CarnivalModel>) :
    RecyclerView.Adapter<PoiAdapter.PoiHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoiHolder(layoutInflater.inflate(R.layout.items_list_poi, parent, false))
    }

    override fun onBindViewHolder(holder: PoiHolder, position: Int) {
        holder.render(mCarnival[position])

    }

    override fun getItemCount(): Int = mCarnival.size

    class PoiHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun render(mCarnival: CarnivalModel) {
            view.item_title.text = mCarnival.titleItem
            view.item_obs.text = mCarnival.obsItem
            view.item_quality.text = mCarnival.quality
            Picasso.get().load(mCarnival.image).into(view.item_img)
            view.setOnClickListener {
                val data = bundleOf("poi" to mCarnival)
                view.findNavController().navigate(R.id.action_viewListPoi_to_viewDetailPoi, data)
            }
        }
    }

}