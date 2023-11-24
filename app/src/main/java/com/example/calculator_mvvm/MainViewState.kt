package com.example.calculator_mvvm

sealed class MainViewState{

    data class FailCalculate(
        val message: String
    ) : MainViewState()


    data class SuccessCalculate(
        val result: Double
    ): MainViewState()
}
