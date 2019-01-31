package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class WeaponRepositoryImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val repository = WeaponRepositoryImpl(service)

    @Test
    fun getWeaponAll_withSuccess() = runBlocking {

        val mockWeaponList = TestDataFactory.makeDataWeaponList()

        `when`(service.getWeaponAll())
            .thenReturn(CompletableDeferred(mockWeaponList))

        val resultList = repository.getWeaponAll().await()

        assertEquals(resultList, mockWeaponList)
    }

    @Ignore
    @Test
    fun getWeaponAll_withError() = runBlocking {

    }
}