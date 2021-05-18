package com.raindragonn.dager2ex

import android.os.Bundle
import com.raindragonn.dager2ex.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            tvTest.text = "hi"
        }
    }
}