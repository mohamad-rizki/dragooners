package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.remote.service.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ItemRemoteDataSourceImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val dataSource = ItemRemoteDataSourceImpl(service)

    @Test
    fun getItemAll_withSuccess() = runBlocking {

        val mockItemList = TestDataFactory.makeDataItemList(10)

        `when`(service.getItemAll())
            .thenReturn(CompletableDeferred(mockItemList))

        val resultList = dataSource.getItemAll().await()

        assertEquals(resultList, mockItemList)
    }
}