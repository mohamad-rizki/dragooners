package com.dafian.android.dragooners.presentation.ui.weapon

import com.dafian.android.dragooners.domain.model.Weapon
import com.dafian.android.dragooners.presentation.base.BasePresenter
import com.dafian.android.dragooners.presentation.base.BaseView
import com.dafian.android.dragooners.presentation.base.BaseViewState

interface WeaponContract {

    abstract class Presenter : BasePresenter() {

        abstract fun getWeaponAll()
    }

    interface View : BaseView

    sealed class WeaponViewState : BaseViewState() {

        data class ResultStateWeapon(val weaponList: List<Weapon>) : BaseViewState()
    }
}