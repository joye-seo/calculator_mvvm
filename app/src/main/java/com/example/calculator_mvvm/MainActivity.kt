package com.example.calculator_mvvm

import android.widget.Toast
import androidx.activity.viewModels
import com.example.calculator_mvvm.base.BaseActivity
import com.example.calculator_mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewState>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun initUi() {
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }
    }

    override fun onChangedViewState(viewState: MainViewState) {
        when (viewState) {
            is MainViewState.GetData -> {
                binding.tvResult.text = viewState.string
            }

            is MainViewState.ShowToast -> {
                Toast.makeText(this, viewState.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}