package com.raindragonn.dager2ex

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// Created by raindragonn on 2021/05/18.

abstract class BaseActivity<V : ViewBinding>(bindingFactory: (LayoutInflater) -> V) : AppCompatActivity() {
    protected val binding: V by lazy { bindingFactory(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}