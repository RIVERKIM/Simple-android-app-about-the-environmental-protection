package com.example.teama.features.Energy

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
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


        binding.energyBack.setOnClickListener {
            requireActivity().onBackPressed()
        }


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
            v.setBackgroundResource(R.drawable.off)
            falseCount = falseCount!! + 1
        }else {
            state[idx] = true
            v.setBackgroundResource(R.drawable.on)
            falseCount = falseCount!! - 1
        }
        Log.d("dfdf", falseCount.toString())
        if(falseCount!! == 0) {
            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage("Win. Get Point!!")
                    .setPositiveButton("Go To Main", DialogInterface.OnClickListener {
                        dialog, id ->

                        AndroidApplication.point = AndroidApplication.point!! + 30
                        AndroidApplication.money = AndroidApplication.money!! + 30
                        val intent = MainActivity.callIntent(requireContext())
                        startActivity(intent)
                    }).setCancelable(false)

            builder.create()
            builder.show()
        }else if(falseCount == 8) {
            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage("Fail. Lose Point!!")
                .setPositiveButton("Go To Main", DialogInterface.OnClickListener {
                        dialog, id ->

                    if(AndroidApplication.point!! > 30) AndroidApplication.point = AndroidApplication.point!! - 30
                    else AndroidApplication.point = 0

                    val intent = MainActivity.callIntent(requireContext())
                    startActivity(intent)
                }).setCancelable(false)

            builder.create()
            builder.show()
        }
    }
}