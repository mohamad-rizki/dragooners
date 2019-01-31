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

class CharmRepositoryImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val repository = CharmRepositoryImpl(service)

    @Test
    fun getCharmAll_withSuccess() = runBlocking {

        val mockCharmList = TestDataFactory.makeDataCharmList()

        `when`(service.getCharmAll())
            .thenReturn(CompletableDeferred(mockCharmList))

        val resultList = repository.getCharmAll().await()

        assertEquals(resultList, mockCharmList)
    }

    @Ignore
    @Test
    fun getCharmAll_withError() = runBlocking {

    }
}