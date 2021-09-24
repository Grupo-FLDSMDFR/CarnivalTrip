package com.example.carnivaltrip

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carnivaltrip.databinding.FragmentViewListPoiBinding
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_view_list_poi.*
import java.io.IOException

class ViewListPoi : Fragment() {

    private lateinit var binding: FragmentViewListPoiBinding
    private lateinit var adapter: PoiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_view_list_poi, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewListPoiBinding.bind(view)
        initRecycler()
    }

    private fun initRecycler(){
        val poi = proccesListPoi()
        binding.rListPoi.layoutManager = LinearLayoutManager(requireActivity())
        adapter = PoiAdapter(poi)
        binding.rListPoi.adapter=adapter

    }

    private fun proccesListPoi(): List<ListPoi> {
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