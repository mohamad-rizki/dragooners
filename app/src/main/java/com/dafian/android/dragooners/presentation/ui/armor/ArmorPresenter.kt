package com.dafian.android.dragooners.presentation.ui.armor

import com.dafian.android.dragooners.domain.repository.ArmorRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class ArmorPresenter(
    private val armorRepository: ArmorRepository
) : ArmorContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getArmorAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = armorRepository.getArmorAll().await()
                viewStates.send(ArmorContract.ArmorViewState.ResultStateArmor(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}