package com.dafian.android.dragooners.presentation.ui.skill

import com.dafian.android.dragooners.presentation.base.BaseViewState
import com.dafian.android.dragooners.usecase.GetSkillAllUseCase
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class SkillPresenterTest {

    private val useCase = Mockito.mock(GetSkillAllUseCase::class.java)

    private val presenter = SkillPresenter(useCase)

    @Test
    fun getSkillAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataSkillList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(useCase.getSkillAll())
            .thenReturn(CompletableDeferred(expectedResponse))

        launch {
            presenter.getSkillAll()
        }
        repeat(2) {
            actualStates.add(viewStateChannel.receive())
        }

        assertEquals(actualStates[0], BaseViewState.LoadingState)
        assertTrue(actualStates[1] is SkillContract.SkillViewState.ResultStateSkill)
        assertEquals((actualStates[1] as SkillContract.SkillViewState.ResultStateSkill).skillList, expectedResponse)
    }

    @Ignore("Error exist")
    @Test
    fun getSkillAll_withError() = runBlocking {

    }
}