package com.example.teama.features.transport

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaController2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.TransportFragmentBinding
import com.example.teama.features.database.Recycle
import com.example.teama.features.main.MainActivity
import com.google.android.material.snackbar.Snackbar

class TransportFragment: BaseFragment() {

    private val WALK_MONEY = 0
    private val WALK_POINT = 200

    private val BIKE_MONEY = 50
    private val BIKE_POINT = 100

    private val CAR_MONEY = 200
    private val CAR_POINT = 20

    private lateinit var binding: TransportFragmentBinding


    override fun layoutId() = R.layout.transport_fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = TransportFragmentBinding.inflate(inflater, container, false)

        binding.back.setOnClickListener {

            requireActivity().onBackPressed()
        }

        binding.walk.setOnClickListener {
            if(AndroidApplication.money!! >= WALK_MONEY) {
                AndroidApplication.money = AndroidApplication.money!! - WALK_MONEY
                AndroidApplication.point = AndroidApplication.point!! + WALK_POINT
                onClick(it)
            }else {
                Snackbar.make(requireView(), "Not enough money", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.bike.setOnClickListener {
            if(AndroidApplication.money!! >= BIKE_MONEY) {
                AndroidApplication.money = AndroidApplication.money!! - BIKE_MONEY
                AndroidApplication.point = AndroidApplication.point!! + BIKE_POINT
                onClick(it)
            }else {
                Snackbar.make(requireView(), "Not enough money", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.car.setOnClickListener {
            if(AndroidApplication.money!! >= CAR_MONEY) {
                AndroidApplication.money = AndroidApplication.money!! - CAR_MONEY
                AndroidApplication.point = AndroidApplication.point!! + CAR_POINT
                onClick(it)
            }else {
                Snackbar.make(requireView(), "Not enough money", Snackbar.LENGTH_SHORT).show()
            }
        }



        return binding.root
    }
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val intent = MainActivity.callIntent(requireContext())
            startActivity(intent)
        }
    }

    private fun onClick(v: View) {

        val builder = AlertDialog.Builder(requireContext())

        val inflater = requireActivity().layoutInflater


        val view = inflater.inflate(R.layout.popup_activity,null)

        val childView = view.findViewById<ImageView>(R.id.transport_image)

        when(v.tag.toString()) {
            "walk" -> childView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_directions_walk_24))
            "bike" -> childView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_pedal_bike_24))
            "car" -> childView.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_directions_car_24))
        }


        builder.setView(view)
            .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, id ->
                val intent = MainActivity.callIntent(requireContext())
                startActivity(intent)
            })

        builder.create()

        builder.show()



//        val intent = PopupActivity.callIntent(requireContext())
//
//        intent.putExtra("name", v.tag.toString())
//        resultLauncher.launch(intent)
    }
}