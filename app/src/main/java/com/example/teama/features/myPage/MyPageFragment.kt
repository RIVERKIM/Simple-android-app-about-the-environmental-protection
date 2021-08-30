package com.example.teama.features.myPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.MypageFragmentBinding

class MyPageFragment:BaseFragment() {

    override fun layoutId() = R.layout.mypage_fragment
    private lateinit var binding: MypageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MypageFragmentBinding.inflate(inflater, container, false)

        binding.mypageBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.mypageName.text = AndroidApplication.user!!
        binding.mypageCo2.text = AndroidApplication.co2!!.toString()
        binding.mypageMoney.text = AndroidApplication.money!!.toString()
        binding.mypagePoint.text = AndroidApplication.point!!.toString()



        return binding.root
    }

}