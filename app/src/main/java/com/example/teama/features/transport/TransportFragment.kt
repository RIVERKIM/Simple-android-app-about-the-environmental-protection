package com.example.teama.features.transport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.TransportFragmentBinding

class TransportFragment: BaseFragment() {

    private lateinit var binding: TransportFragmentBinding
    override fun layoutId() = R.layout.transport_fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TransportFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}