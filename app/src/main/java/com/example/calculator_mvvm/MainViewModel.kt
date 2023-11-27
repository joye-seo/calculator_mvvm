package com.example.calculator_mvvm

import androidx.lifecycle.MutableLiveData
import com.example.calculator_mvvm.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    val firstNum: MutableLiveData<String> = MutableLiveData("")
    val secondNum: MutableLiveData<String> = MutableLiveData("")

    fun calc(operator: Operation) {
        val aInt = firstNum.value?.toIntOrNull() ?: 0
        val bInt = secondNum.value?.toIntOrNull() ?: 0

        onChangedViewState(MainViewState.GetData(calculate(operator, aInt, bInt).toString()))
    }

    private fun calculate(operator: Operation, x: Int, y: Int): Int {
        return when (operator) {
            Operation.PLUS -> x + y
            Operation.MINUS -> x - y
            Operation.MULTIPLE -> x * y
            Operation.DIVIDE -> x / y
        }
    }
}

