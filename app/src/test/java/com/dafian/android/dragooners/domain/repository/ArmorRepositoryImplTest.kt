package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ArmorRepositoryImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val repository = ArmorRepositoryImpl(service)

    @Test
    fun getArmorAll_withSuccess() = runBlocking {

        val mockArmorList = TestDataFactory.makeDataArmorList(10)

        `when`(service.getArmorAll())
            .thenReturn(CompletableDeferred(mockArmorList))

        val resultList = repository.getArmorAll().await()

        assertEquals(resultList, mockArmorList)
    }

    @Test
    fun getArmorAll_withError() = runBlocking {

        val mockError = Throwable("Something error")

        `when`(service.getArmorAll())
            .thenThrow(mockError)

        repository.getArmorAll().await()

        Unit
    }
}