package com.dafian.android.dragooners.presentation.base

abstract class BaseViewState {

    object LoadingState : BaseViewState()

    class ErrorState(val throwable: Throwable) : BaseViewState()
}