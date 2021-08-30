package com.example.teama.features.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
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
import com.example.teama.features.home.HomeActivity
import com.example.teama.features.home.HomeFragment
import com.example.teama.features.myPage.MyPageActivity
import com.example.teama.features.recycle2.Recycle2Activity
import com.example.teama.features.transport.TransportActivity
import com.example.teama.features.transport.TransportFragment
import org.w3c.dom.Text

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


        if(AndroidApplication.co2!! == 100.0) {

            viewModel.delete()

            val builder = AlertDialog.Builder(requireContext())

            val inflater = requireActivity().layoutInflater


            val view = inflater.inflate(R.layout.popup_activity,null)

            view.findViewById<TextView>(R.id.transport_name).setText("CO2 Exceed 100.0!!!!")
            val childView = view.findViewById<ImageView>(R.id.transport_image)

            childView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_thumb_down_alt_24))

            builder.setView(view)
                .setPositiveButton("You Lose", DialogInterface.OnClickListener { dialog, id ->

                    val intent = HomeActivity.callIntent(requireContext())
                    startActivity(intent)

                }).setCancelable(false)

            builder.create()

            builder.show()
        }


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

        binding.quiz.setOnClickListener {
            val intent = RecycleActivity.callIntent(requireContext())

            startActivity(intent)
        }

        binding.rc.setOnClickListener {
            val intent = Recycle2Activity.callIntent(requireContext())
            startActivity(intent)
        }

        binding.logOut.setOnClickListener {
            viewModel.reset()
            val intent = HomeActivity.callIntent(requireContext())
            startActivity(intent)
        }

        binding.myPage.setOnClickListener {
            val intent = MyPageActivity.callIntent(requireContext())
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
