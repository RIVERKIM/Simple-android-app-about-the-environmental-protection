package com.example.teama.features.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ekn.gruzer.gaugelibrary.Range
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.extension.appContext
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.MainFragmentBinding
import com.example.teama.features.transport.TransportActivity

class MainFragment: BaseFragment() {

    private lateinit var binding: MainFragmentBinding
    override fun layoutId() = R.layout.main_fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)

        binding.transport.setOnClickListener {
            val intent = TransportActivity.callIntent(requireContext())

            startActivity(intent)
        }

        setRange()

        return binding.root
    }

    private fun setRange() {
        val rangeGreen = Range()
        rangeGreen.color = Color.parseColor("#ce0000")
        rangeGreen.from = 0.0
        rangeGreen.to = 30.0

        val rangeYellow = Range()

        rangeYellow.color = Color.parseColor("#E3E500")
        rangeYellow.from = 30.0
        rangeYellow.to = 70.0

        val rangeRed = Range()
        rangeRed.color = Color.parseColor("#00b20b")
        rangeRed.from = 70.0
        rangeRed.to = 100.0

        binding.fullGauge.addRange(rangeGreen)
        binding.fullGauge.addRange(rangeYellow)
        binding.fullGauge.addRange(rangeRed)

        binding.fullGauge.minValue = 0.0
        binding.fullGauge.maxValue = 100.0
        binding.fullGauge.value = 40.0

    }
}