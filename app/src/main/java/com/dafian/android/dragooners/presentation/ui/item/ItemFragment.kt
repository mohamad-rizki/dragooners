package com.dafian.android.dragooners.presentation.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.dragooners.presentation.base.BaseFragment
import com.dafian.android.dragooners.presentation.base.BaseViewState

class ItemFragment : BaseFragment(), ItemContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun renderState(viewState: BaseViewState) {

    }
}