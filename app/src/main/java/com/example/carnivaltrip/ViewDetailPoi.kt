package com.example.carnivaltrip

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.carnivaltrip.databinding.FragmentViewDetailPoiBinding
import com.squareup.picasso.Picasso

class ViewDetailPoi : Fragment() {

    private lateinit var binding: FragmentViewDetailPoiBinding
    private var mCarnival: CarnivalModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_view_detail_poi, container, false)
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
        setHasOptionsMenu(true)
        binding = FragmentViewDetailPoiBinding.bind(view)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            view.findNavController().navigate(R.id.action_viewDetailPoi_to_viewListPoi)
        }

        arguments?.let {
            mCarnival = it.getParcelable("poi")
        }

        binding.titleView.text = mCarnival!!.titleItem
        Picasso.get().load(mCarnival!!.image).into(binding.imageView)
        binding.descriptionView.text = mCarnival!!.obsItem
        binding.titleCarnival.text = mCarnival!!.carnival
        binding.descriptionCarnival.text = mCarnival!!.obsCarnival
        binding.valTemperature.text = mCarnival!!.temp
        binding.valDate.text = mCarnival!!.date
    }

}