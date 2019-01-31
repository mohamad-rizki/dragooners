package com.dafian.android.dragooners.presentation.ui.weapon

import com.dafian.android.dragooners.domain.repository.WeaponRepository
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
class WeaponPresenterTest {

    private val repository = Mockito.mock(WeaponRepository::class.java)

    private val presenter = WeaponPresenter(repository)

    @Test
    fun getWeaponAll_withSuccess() = runBlocking {

        val expectedResponse = TestDataFactory.makeDataWeaponList()
        val viewStateChannel = presenter.viewStates
        val actualStates = mutableListOf<BaseViewState>()

        `when`(repository.getWeaponAll())
            .thenReturn(CompletableDeferred(expectedResponse))

        launch {
            presenter.getWeaponAll()
        }
        repeat(2) {
            actualStates.add(viewStateChannel.receive())
        }

        assertEquals(actualStates[0], BaseViewState.LoadingState)
        assertTrue(actualStates[1] is WeaponContract.WeaponViewState.ResultStateWeapon)
        assertEquals((actualStates[1] as WeaponContract.WeaponViewState.ResultStateWeapon).weaponList, expectedResponse)
    }

    @Ignore
    @Test
    fun getWeaponAll_withError() = runBlocking {

    }

}