package com.example.teama.features.recycle2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.Recycle4FragmentBinding
import com.example.teama.features.main.MainActivity

class Recycle2_3_Fragment:BaseFragment() {

    private lateinit var binding: Recycle4FragmentBinding

    override fun layoutId() = R.layout.recycle4_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Recycle4FragmentBinding.inflate(inflater, container, false)

        binding.recycle3Back.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Recycle_2_2_Fragment()).commit()
        }


        binding.plastic.setOnClickListener {
            onClick(it)
        }

        binding.can.setOnClickListener {
            onClick(it)
        }

        binding.paper.setOnClickListener {
            onClick(it)
        }

        return binding.root
    }

    fun onClick(v: View) {

        val isCorrect = (v.tag.toString() == "plastic")
        var message = "Wrong. Lose Point.."
        if(isCorrect) {
            message = "Correct. Get Point!"
        }

            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage(message)
                    .setPositiveButton("Go to Main", DialogInterface.OnClickListener {
                        dialog, id ->
                        if(isCorrect) {
                            AndroidApplication.point = AndroidApplication.point!! + 30
                            AndroidApplication.money = AndroidApplication.money!! + 30
                        }else {
                            if(AndroidApplication.point!! > 30)AndroidApplication.point =  AndroidApplication.point!! - 30
                            else AndroidApplication.point = 0
                        }

                        val intent = MainActivity.callIntent(requireContext())
                        startActivity(intent)
                    }).setCancelable(false)
            builder.create()
            builder.show()

    }
}