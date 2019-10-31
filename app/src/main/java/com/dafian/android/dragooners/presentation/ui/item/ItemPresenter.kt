package com.dafian.android.dragooners.presentation.ui.item

import com.dafian.android.dragooners.presentation.base.BaseViewState
import com.dafian.android.dragooners.usecase.GetItemAllUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class ItemPresenter(
    private val getItemAllUseCase: GetItemAllUseCase
) : ItemContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getItemAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = getItemAllUseCase.getItemAll().await()
                viewStates.send(ItemContract.ItemViewState.ResultStateItem(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}