package com.dafian.android.dragooners.presentation.ui.charm

import com.dafian.android.dragooners.domain.entity.Charm
import com.dafian.android.dragooners.presentation.base.BasePresenter
import com.dafian.android.dragooners.presentation.base.BaseView
import com.dafian.android.dragooners.presentation.base.BaseViewState

interface CharmContract {

    abstract class Presenter : BasePresenter() {

        abstract fun getCharmAll()
    }

    interface View : BaseView

    sealed class CharmViewState : BaseViewState() {

        data class ResultStateCharm(val charmList: List<Charm>) : BaseViewState()
    }
}