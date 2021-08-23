package com.example.teama.features.Recycle

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.RecycleFragmentBinding
import com.example.teama.features.main.MainActivity

class RecycleFragment: BaseFragment() {

    private var count: Int? = null
    override fun layoutId() = R.layout.recycle_fragment

    private lateinit var binding:RecycleFragmentBinding
    private lateinit var quiz: Array<Int>
    private var idx: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = RecycleFragmentBinding.inflate(inflater, container, false)

        //1 캔 2 페트 3 종이 4.일반쓰레기
        count = 0
        idx = 0

        quiz = arrayOf(R.drawable.cc,R.drawable.p1,R.drawable.bb,R.drawable.cc2,R.drawable.p3,R.drawable.paper,R.drawable.cc3)


        binding.rBtn1.setOnClickListener {
            onClick(it)
        }

        binding.rBtn2.setOnClickListener {
            onClick(it)
        }


        return binding.root
    }

    private fun onClick(v:View) {

            var temp = 0

            if(v.tag == "r") {
                temp = 1
            }else if(v.tag == 'g') {
                temp = 2
            }

            when(idx) {
                2 -> if(temp == 2) count = count!! + 1
                else -> if(temp == 1) count = count!! + 1
            }

            Log.d("aa", count.toString())
            Log.d("dfdf", idx.toString())

            binding.pic.setBackgroundResource(quiz[idx!!])

        idx = idx!! + 1


        if(idx == 7) {
            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage(count.toString() + " Correct!!")
                    .setPositiveButton("Go to Main", DialogInterface.OnClickListener {
                        dialog, id ->

                        AndroidApplication.point = AndroidApplication.point!! + 10 * count!!

                        val intent = MainActivity.callIntent(requireContext())
                        startActivity(intent)
                    })

            builder.create()
            builder.show()
        }
    }
}