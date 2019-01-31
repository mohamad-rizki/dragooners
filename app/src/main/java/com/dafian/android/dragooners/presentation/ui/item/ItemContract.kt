package com.dafian.android.dragooners.presentation.ui.item

import com.dafian.android.dragooners.domain.entity.Item
import com.dafian.android.dragooners.presentation.base.BasePresenter
import com.dafian.android.dragooners.presentation.base.BaseView
import com.dafian.android.dragooners.presentation.base.BaseViewState

interface ItemContract {

    abstract class Presenter : BasePresenter() {

        abstract fun getItemAll()
    }

    interface View : BaseView

    sealed class ItemViewState : BaseViewState() {

        data class ResultStateItem(val itemList: List<Item>) : BaseViewState()
    }
}