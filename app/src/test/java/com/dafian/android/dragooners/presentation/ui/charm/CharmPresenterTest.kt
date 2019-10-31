package com.dafian.android.dragooners.presentation.ui.charm

import com.dafian.android.dragooners.presentation.base.BaseViewState
import com.dafian.android.dragooners.usecase.GetCharmAllUseCase
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
class CharmPresenterTest {

    private val useCase = Mockito.mock(GetCharmAllUseCase::class.java)

    private val presenter = CharmPresenter(useCase)

    @Test
    fun getCharmAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataCharmList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(useCase.getCharmAll())
            .thenReturn(CompletableDeferred(expectedResponse))

        launch {
            presenter.getCharmAll()
        }
        repeat(2) {
            actualStates.add(viewStateChannel.receive())
        }

        assertEquals(actualStates[0], BaseViewState.LoadingState)
        assertTrue(actualStates[1] is CharmContract.CharmViewState.ResultStateCharm)
        assertEquals((actualStates[1] as CharmContract.CharmViewState.ResultStateCharm).charmList, expectedResponse)
    }

    @Ignore("Error exist")
    @Test
    fun getCharmAll_withError() = runBlocking {

    }
}