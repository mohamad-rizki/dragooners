package com.dafian.android.dragooners.presentation.ui.skill

import com.dafian.android.dragooners.domain.model.Skill
import com.dafian.android.dragooners.presentation.base.BasePresenter
import com.dafian.android.dragooners.presentation.base.BaseView
import com.dafian.android.dragooners.presentation.base.BaseViewState

interface SkillContract {

    abstract class Presenter : BasePresenter() {

        abstract fun getSkillAll()
    }

    interface View : BaseView

    sealed class SkillViewState : BaseViewState() {

        data class ResultStateSkill(val skillList: List<Skill>) : BaseViewState()
    }
}