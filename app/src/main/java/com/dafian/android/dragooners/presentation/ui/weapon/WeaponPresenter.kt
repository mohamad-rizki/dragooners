package com.dafian.android.dragooners.presentation.ui.weapon

import com.dafian.android.dragooners.domain.repository.WeaponRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class WeaponPresenter(
    private val weaponRepository: WeaponRepository
) : WeaponContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getWeaponAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = weaponRepository.getWeaponAll().await()
                viewStates.send(WeaponContract.WeaponViewState.ResultStateWeapon(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}