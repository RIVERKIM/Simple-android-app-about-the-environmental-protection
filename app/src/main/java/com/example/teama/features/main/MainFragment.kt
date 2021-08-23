package com.example.teama.features.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ekn.gruzer.gaugelibrary.Range
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.extension.appContext
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.MainFragmentBinding
import com.example.teama.features.Energy.EnergyActivity
import com.example.teama.features.Energy.EnergyFragment
import com.example.teama.features.Recycle.RecycleActivity
import com.example.teama.features.database.RecycleDatabase
import com.example.teama.features.home.HomeFragment
import com.example.teama.features.transport.TransportActivity
import com.example.teama.features.transport.TransportFragment

class MainFragment: BaseFragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    override fun layoutId() = R.layout.main_fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Main layout data binding
        binding = MainFragmentBinding.inflate(inflater, container, false)

        val dataSource = RecycleDatabase.getInstance(AndroidApplication.getContext()).recycleDatabaseDao()

        val viewModelFactory = MainViewModelFactory(dataSource)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.update()

       binding.money.text = AndroidApplication.money.toString()
       binding.point.text = AndroidApplication.point.toString()

        binding.transport.setOnClickListener {
            val intent = TransportActivity.callIntent(requireContext())

            startActivity(intent)
        }

        binding.power.setOnClickListener {
            val intent = EnergyActivity.callIntent(requireContext())

            startActivity(intent)
        }

        binding.rc.setOnClickListener {
            val intent = RecycleActivity.callIntent(requireContext())

            startActivity(intent)
        }

        setRange()
    }

    //co2 gauge setting
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
        binding.fullGauge.value = AndroidApplication.co2!!


    }
}
