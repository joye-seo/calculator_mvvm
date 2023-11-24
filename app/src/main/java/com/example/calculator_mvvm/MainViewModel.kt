package com.example.calculator_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _calculateState: MutableLiveData<MainViewState> = MutableLiveData()
    val calculateState = _calculateState

    val firstNum: MutableLiveData<String> = MutableLiveData("0")

    val secondNum: MutableLiveData<String> = MutableLiveData("0")

    fun calculate(operator: Button) {

        if (firstNum.value == null || secondNum.value == null) {
            _calculateState.value = MainViewState.FailCalculate("값을 입력해주세요")
            return
        }

        val firstResult = firstNum.value!!.toDouble()
        val secondResult = secondNum.value!!.toDouble()

        when (operator) {
            Button.PLUS -> {
                _calculateState.value = MainViewState.SuccessCalculate(firstResult + secondResult)
            }

            Button.MINUS -> {
                _calculateState.value = MainViewState.SuccessCalculate(firstResult - secondResult)
            }

            Button.MULTIPLE -> {
                _calculateState.value = MainViewState.SuccessCalculate(firstResult * secondResult)
            }

            Button.DIVIDE -> {
                if (secondResult == 0.0) {
                    _calculateState.value = MainViewState.FailCalculate("0으로 나눌 수 없습니다.")
                    return
                }
                //소수점 2번째 자리까지 반올림으로 표현
                _calculateState.value = MainViewState.SuccessCalculate((firstResult / secondResult).toDouble())
            }
        }
    }
}

