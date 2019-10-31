package com.dafian.android.dragooners.presentation.ui.item

import com.dafian.android.dragooners.presentation.base.BaseViewState
import com.dafian.android.dragooners.usecase.GetItemAllUseCase
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
class ItemPresenterTest {

    private val useCase = Mockito.mock(GetItemAllUseCase::class.java)

    private val presenter = ItemPresenter(useCase)

    @Test
    fun getItemAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataItemList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(useCase.getItemAll())
            .thenReturn(CompletableDeferred(expectedResponse))

        launch {
            presenter.getItemAll()
        }
        repeat(2) {
            actualStates.add(viewStateChannel.receive())
        }

        assertEquals(actualStates[0], BaseViewState.LoadingState)
        assertTrue(actualStates[1] is ItemContract.ItemViewState.ResultStateItem)
        assertEquals((actualStates[1] as ItemContract.ItemViewState.ResultStateItem).itemList, expectedResponse)
    }

    @Ignore("Error exist")
    @Test
    fun getItemAll_withError() = runBlocking {

    }
}