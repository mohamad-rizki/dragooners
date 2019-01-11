package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ItemRepositoryImplTest {

    private val service = mock(RestService::class.java)

    private val repository = ItemRepositoryImpl(service)

    @Test
    fun getItemAll_withSuccess() = runBlocking {

        val mockItemList = TestDataFactory.makeDataItemList(10)

        `when`(service.getItemAll())
            .thenReturn(CompletableDeferred(mockItemList))

        val resultList = repository.getItemAll().await()

        assertEquals(resultList, mockItemList)
    }

    @Test
    fun getItemAll_withError() = runBlocking {

        val mockError = IllegalArgumentException("Something error")

        `when`(service.getItemAll())
            .thenThrow(mockError)

        repository.getItemAll().await()

        Unit
    }
}