package com.example.teama.features.recycle2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.Recycle3FragmentBinding

class Recycle_2_2_Fragment:BaseFragment(){

    private lateinit var binding:Recycle3FragmentBinding

    override fun layoutId() = R.layout.recycle3_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Recycle3FragmentBinding.inflate(inflater, container, false)

        binding.recycle3Back.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Recycle2_1_Fragment()).commit()
        }

        binding.nextBtn.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Recycle2_3_Fragment()).commit()
        }

        return binding.root
    }
}