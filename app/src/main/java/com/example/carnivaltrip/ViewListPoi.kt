package com.example.carnivaltrip

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carnivaltrip.databinding.FragmentViewListPoiBinding

class ViewListPoi : Fragment() {

    private lateinit var binding: FragmentViewListPoiBinding
    private lateinit var viewModel: PoiViewModel

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
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewListPoiBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PoiViewModel::class.java)

        initRecycler()
    }

    private fun initRecycler() {
        viewModel.getCarnival().observe(viewLifecycleOwner, Observer {
            binding.rListPoi.layoutManager = LinearLayoutManager(requireActivity())
            binding.rListPoi.adapter = PoiAdapter(it)
        })
    }
}