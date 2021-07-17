package com.example.myspace.ui.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myspace.MainViewModel
import com.example.myspace.R
import com.example.myspace.extensions.activityViewModelProvider
import com.example.myspace.extensions.viewModelProvider
import com.example.myspace.fragment.BaseFragment

class AboutUsFragment : BaseFragment() {

    private lateinit var aboutUsViewModel: AboutUsViewModel
    lateinit var aboutUsMainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        aboutUsViewModel = viewModelProvider()
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutUsMainViewModel = activityViewModelProvider()
    }
}