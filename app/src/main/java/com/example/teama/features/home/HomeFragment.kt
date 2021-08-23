package com.example.teama.features.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.core.platform.BaseFragment
import com.example.teama.databinding.HomeFragmentBinding
import com.example.teama.features.database.Recycle
import com.example.teama.features.database.RecycleDatabase
import com.example.teama.features.database.RecycleDatabaseDao
import com.example.teama.features.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class HomeFragment: BaseFragment() {

    private lateinit var binding:HomeFragmentBinding
    private lateinit var database: RecycleDatabaseDao
    override fun layoutId() = R.layout.home_fragment

    val scope = CoroutineScope(Job() + Dispatchers.Main)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        // navigate to MainActivity
        binding.playButton.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())

            val inflater = requireActivity().layoutInflater.inflate(R.layout.login_popup, null)

            val view = inflater.findViewById<EditText>(R.id.username)


            database = RecycleDatabase.getInstance(AndroidApplication.getContext()).recycleDatabaseDao()

            builder.setView(inflater)
                    .setPositiveButton("Login", DialogInterface.OnClickListener { dialog, id ->

                        var username:String = view.text.toString().trim()

                        if(TextUtils.isEmpty(username)) {
                            Snackbar.make(binding.root, "Please enter username", Snackbar.LENGTH_SHORT).show()
                        }else {
                            AndroidApplication.user = username

                            scope.launch {
                                var info =  database.get(username)

                                if(info == null) {
                                    val new = Recycle(AndroidApplication.user!!, 100.0, 100, 100)

                                    database.insert(new)

                                    info = new
                                }

                                AndroidApplication.co2 = info.co2_rate
                                AndroidApplication.money = info.money
                                AndroidApplication.point = info.point

                                val intent = MainActivity.callIntent(requireContext())
                                startActivity(intent)
                            }


                        }

                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener {dialog, id ->
                        dialog.cancel()
                    })

            builder.create()
            builder.show()
        }



        return binding.root
    }
}