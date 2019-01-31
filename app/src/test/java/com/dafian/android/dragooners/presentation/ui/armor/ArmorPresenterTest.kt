package com.dafian.android.dragooners.presentation.ui.armor

import com.dafian.android.dragooners.domain.repository.ArmorRepository
import com.dafian.android.dragooners.presentation.base.BaseViewState
import com.dafian.android.dragooners.util.TestDataFactory
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class ArmorPresenterTest {

    private val repository = mock(ArmorRepository::class.java)

    private val presenter = ArmorPresenter(repository)

    @Test
    fun getArmorAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataArmorList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(repository.getArmorAll())
            .thenReturn(CompletableDeferred(expectedResponse))

        launch {
            presenter.getArmorAll()
        }
        repeat(2) {
            actualStates.add(viewStateChannel.receive())
        }

        assertEquals(actualStates[0], BaseViewState.LoadingState)
        assertTrue(actualStates[1] is ArmorContract.ArmorViewState.ResultStateArmor)
        assertEquals((actualStates[1] as ArmorContract.ArmorViewState.ResultStateArmor).armorList, expectedResponse)
    }

    @Ignore
    @Test
    fun getArmorAll_withError() = runBlocking {

    }
}