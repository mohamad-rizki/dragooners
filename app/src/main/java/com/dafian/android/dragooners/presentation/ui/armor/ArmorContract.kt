package com.dafian.android.dragooners.presentation.ui.armor

import com.dafian.android.dragooners.domain.entity.Armor
import com.dafian.android.dragooners.presentation.base.BasePresenter
import com.dafian.android.dragooners.presentation.base.BaseView
import com.dafian.android.dragooners.presentation.base.BaseViewState

interface ArmorContract {

    abstract class Presenter : BasePresenter() {

        abstract fun getArmorAll()
    }

    interface View : BaseView

    sealed class ArmorViewState : BaseViewState() {

        data class ResultStateArmor(val armorList: List<Armor>) : BaseViewState()
    }
}