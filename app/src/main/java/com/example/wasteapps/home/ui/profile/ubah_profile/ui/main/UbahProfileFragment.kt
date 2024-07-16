package com.example.wasteapps.home.ui.profile.ubah_profile.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wasteapps.R


class UbahProfileFragment : Fragment() {

    companion object {
        fun newInstance() = UbahProfileFragment()
    }

    private lateinit var viewModel: UbahProfileModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UbahProfileModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_ubah_profile, container, false)
    }

}