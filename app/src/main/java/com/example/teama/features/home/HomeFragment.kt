package com.example.teama.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.HomeFragmentBinding
import com.example.teama.features.main.MainActivity

class HomeFragment: BaseFragment() {

    private lateinit var binding:HomeFragmentBinding
    override fun layoutId() = R.layout.home_fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        // navigate to MainActivity
        binding.playButton.setOnClickListener {
            val intent = MainActivity.callIntent(requireContext())

            startActivity(intent)
        }

        return binding.root
    }
}