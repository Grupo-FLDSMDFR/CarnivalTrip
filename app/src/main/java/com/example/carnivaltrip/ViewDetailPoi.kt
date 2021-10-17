package com.example.carnivaltrip

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.carnivaltrip.databinding.FragmentViewDetailPoiBinding
import com.squareup.picasso.Picasso
import android.content.Intent




class ViewDetailPoi : Fragment() {

    private lateinit var binding: FragmentViewDetailPoiBinding
    private var dPoi: ListPoi? = null

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
            dPoi = it.getParcelable("poi")
        }

        binding.titleView.text = dPoi!!.titleItem
        Picasso.get().load(dPoi!!.image).into(binding.imageView)
        binding.descriptionView.text = dPoi!!.obsItem
        binding.titleCarnival.text = dPoi!!.carnival
        binding.descriptionCarnival.text = dPoi!!.obsCarnival
        binding.valTemperature.text = dPoi!!.temp
        binding.valDate.text = dPoi!!.date

        binding.button.setOnClickListener{
            val intent = Intent(activity, MapsActivity::class.java)
            intent.putExtra("latitude", dPoi!!.latitude)
            intent.putExtra("longitude", dPoi!!.longitude)
            startActivity(intent)
        }
    }

}