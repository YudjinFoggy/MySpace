package com.example.myspace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myspace.MainViewModel
import com.example.myspace.R
import com.example.myspace.extensions.activityViewModelProvider
import com.example.myspace.extensions.viewModelProvider
import com.example.myspace.fragment.BaseFragment
import com.example.myspace.recycler.SpaceNewsAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : BaseFragment() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel = viewModelProvider()
        
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler)
        homeViewModel.rates.observe(viewLifecycleOwner) {
            val spaceNewsAdapter = SpaceNewsAdapter(it)
            recycler.adapter = spaceNewsAdapter
        }

        homeViewModel.loadAllSpaceNews()

        homeViewModel.errorBus.observe(viewLifecycleOwner)
        {
            context?.let { it1 ->
                MaterialAlertDialogBuilder(it1)
                    .setTitle("Error")
                    .setMessage(it)
                    .show()
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = activityViewModelProvider()
    }
}