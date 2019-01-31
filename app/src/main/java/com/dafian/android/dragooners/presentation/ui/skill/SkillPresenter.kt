package com.dafian.android.dragooners.presentation.ui.skill

import com.dafian.android.dragooners.domain.repository.SkillRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class SkillPresenter(
    private val skillRepository: SkillRepository
) : SkillContract.Presenter() {

    override fun viewStates(): ReceiveChannel<BaseViewState> = viewStates

    override fun getSkillAll() {
        GlobalScope.launch(compositeJob) {
            try {
                viewStates.send(BaseViewState.LoadingState)
                val resultList = skillRepository.getSkillAll().await()
                viewStates.send(SkillContract.SkillViewState.ResultStateSkill(resultList))
            } catch (e: Exception) {
                viewStates.send(BaseViewState.ErrorState(e))
            }
        }
    }
}