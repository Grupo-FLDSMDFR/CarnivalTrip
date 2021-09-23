package com.example.carnivaltrip

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_view_list_poi.*
import java.io.IOException

class ViewListPoi : Fragment() {

    private lateinit var adapter: PoiAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return inflater.inflate(R.layout.fragment_view_list_poi,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler(){
        Log.d("INIIO", "AQUI EMPEZAMOS")
        val poi = procces_list_poi()
        Log.d("RES", poi[0].toString())
        r_list_poi.layoutManager = LinearLayoutManager(requireActivity())
        adapter = PoiAdapter(poi)
        r_list_poi.adapter=adapter
    }

    private fun procces_list_poi(): List<ListPoi> {
        val fileData = getListPoi()
        val gson = GsonBuilder().create()

        return gson.fromJson(fileData, Array<ListPoi>::class.java).toList()
    }

    private fun getListPoi(): String? {
        var gListPoi: String? = null
        try {
            val inputStream = requireContext().assets.open("list_poi.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            gListPoi = String(buffer)
        }catch (e: IOException){
            e.printStackTrace()
        }
        return gListPoi
    }



}