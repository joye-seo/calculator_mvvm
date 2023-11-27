package com.example.calculator_mvvm

import com.example.calculator_mvvm.base.ViewState

sealed class MainViewState : ViewState {

    data class GetData(
        val string: String
    ) : MainViewState()

    data class ShowToast(val message: String) : MainViewState()
}