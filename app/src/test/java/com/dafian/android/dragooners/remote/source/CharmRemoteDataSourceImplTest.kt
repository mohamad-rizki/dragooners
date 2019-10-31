package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.remote.service.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class CharmRemoteDataSourceImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val dataSource = CharmRemoteDataSourceImpl(service)

    @Test
    fun getCharmAll_withSuccess() = runBlocking {

        val mockCharmList = TestDataFactory.makeDataCharmList()

        `when`(service.getCharmAll())
            .thenReturn(CompletableDeferred(mockCharmList))

        val resultList = dataSource.getCharmAll().await()

        assertEquals(resultList, mockCharmList)
    }
}