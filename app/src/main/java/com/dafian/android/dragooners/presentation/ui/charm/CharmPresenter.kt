package com.dafian.android.dragooners.presentation.ui.charm

import com.dafian.android.dragooners.domain.repository.CharmRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class CharmPresenter(
    private val charmRepository: CharmRepository
) : CharmContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getCharmAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = charmRepository.getCharmAll().await()
                viewStates.send(CharmContract.CharmViewState.ResultStateCharm(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}