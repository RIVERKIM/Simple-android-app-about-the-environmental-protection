package com.example.teama.features.Energy

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.EnergyFragmentBinding
import com.example.teama.features.main.MainActivity
import com.example.teama.features.main.MainFragment
import com.google.android.material.snackbar.Snackbar
import java.util.*

class EnergyFragment:BaseFragment() {

    private lateinit var binding:EnergyFragmentBinding

    lateinit var state: Array<Boolean>
    var falseCount: Int? = null

    override fun layoutId() = R.layout.energy_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = EnergyFragmentBinding.inflate(inflater, container, false)

        state = arrayOf(false, false, false, false, true, true, true, true)


        falseCount = 4



        binding.imgBtn1.setOnClickListener {
            onClick(it, 0)
        }

        binding.imgBtn2.setOnClickListener {
            onClick(it, 1)
        }

        binding.imgBtn3.setOnClickListener {
            onClick(it, 2)
        }
        binding.imgBtn4.setOnClickListener {
            onClick(it, 3)
        }
        binding.imgBtn5.setOnClickListener {
            onClick(it, 4)
        }
        binding.imgBtn6.setOnClickListener {
            onClick(it, 5)
        }
        binding.imgBtn7.setOnClickListener {
            onClick(it, 6)
        }

        binding.imgBtn8.setOnClickListener {
            onClick(it, 7)
        }

        return binding.root

    }

    fun onClick(v: View,idx: Int) {
        if(state[idx] == true) {
            state[idx] = false
            v.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
            falseCount = falseCount!! + 1
        }else {
            state[idx] = true
            v.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
            falseCount = falseCount!! - 1
        }
        Log.d("dfdf", falseCount.toString())
        if(falseCount!! == 0) {
            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage("Finish!!")
                    .setPositiveButton("Go to Main", DialogInterface.OnClickListener {
                        dialog, id ->

                        AndroidApplication.point = AndroidApplication.point!! + 50

                        val intent = MainActivity.callIntent(requireContext())
                        startActivity(intent)
                    })

            builder.create()
            builder.show()
        }
    }
}