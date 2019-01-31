package com.dafian.android.dragooners.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

abstract class BasePresenter : ViewModel() {

    internal val compositeJob = Job()
        get() {
            return if (field.isCancelled)
                Job() // canceled job can not be reused, so create a new
            else field
        }

    internal val viewStates = Channel<BaseViewState>()

    abstract fun viewStates() : ReceiveChannel<BaseViewState>

    override fun onCleared() {
        compositeJob.cancel()
        viewStates.cancel()
    }
}