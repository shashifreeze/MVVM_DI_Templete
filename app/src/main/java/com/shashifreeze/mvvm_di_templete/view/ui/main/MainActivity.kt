package com.shashifreeze.mvvm_di_templete.view.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shashifreeze.mvvm_di_templete.R
import com.shashifreeze.mvvm_di_templete.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**Binding*/
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}