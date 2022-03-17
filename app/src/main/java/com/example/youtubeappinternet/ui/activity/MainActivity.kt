package com.example.youtubeappinternet.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.youtubeappinternet.data.network.checkinternet.ConnectivityLiveData
import com.example.youtubeappinternet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData:ConnectivityLiveData
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkNetworkConnection()
    }

    private fun checkNetworkConnection() {
        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this,{isConnected ->

            if(isConnected){

                binding.internet.visibility = View.VISIBLE
                binding.noInternet.visibility = View.GONE

            }else{
                binding.internet.visibility = View.GONE
                binding.noInternet.visibility = View.VISIBLE
            }
        })
    }
}