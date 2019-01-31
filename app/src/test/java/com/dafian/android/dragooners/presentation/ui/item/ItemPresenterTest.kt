package com.dafian.android.dragooners.presentation.ui.item

import com.dafian.android.dragooners.domain.repository.ItemRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
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

    private val repository = Mockito.mock(ItemRepository::class.java)

    private val presenter = ItemPresenter(repository)

    @Test
    fun getItemAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataItemList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(repository.getItemAll())
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

    @Ignore
    @Test
    fun getItemAll_withError() = runBlocking {

    }
}