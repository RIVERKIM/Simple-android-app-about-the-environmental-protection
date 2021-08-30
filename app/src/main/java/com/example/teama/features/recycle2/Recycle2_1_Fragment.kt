package com.example.teama.features.recycle2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.Recycle2FragmentBinding

class Recycle2_1_Fragment: BaseFragment() {
    override fun layoutId() = R.layout.recycle2_fragment

    private lateinit var binding:Recycle2FragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Recycle2FragmentBinding.inflate(inflater, container, false)

        binding.recycle2Back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.nextBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Recycle_2_2_Fragment()).commit()
        }

        return binding.root
    }


}