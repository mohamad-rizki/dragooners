package com.dafian.android.dragooners.presentation.ui.item

import com.dafian.android.dragooners.domain.repository.ItemRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class ItemPresenter(
    private val itemRepository: ItemRepository
) : ItemContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getItemAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = itemRepository.getItemAll().await()
                viewStates.send(ItemContract.ItemViewState.ResultStateItem(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}