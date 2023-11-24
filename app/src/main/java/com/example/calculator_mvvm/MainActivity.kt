package com.example.calculator_mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.calculator_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observeData()
        initView()
    }

    fun initView() = with(binding) {
        lifecycleOwner = this@MainActivity
        viewModel = mainViewModel
    }

    fun observeData() {
        mainViewModel.calculateState.observe(this@MainActivity) { it ->
            when (it) {
                is MainViewState.SuccessCalculate -> {
                    binding.tvResult.text = it.result.toString()
                }

                is MainViewState.FailCalculate -> {
                    binding.tvResult.text = it.message
                }
            }
        }
    }
}