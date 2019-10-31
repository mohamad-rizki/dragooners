package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.ItemRemoteDataSource
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ItemRepositoryImplTest {

    private val dataSource = mock(ItemRemoteDataSource::class.java)

    private val repository =
        ItemRepositoryImpl(dataSource)

    @Test
    fun getItemAll_withSuccess() = runBlocking {

        val mockItemList = TestDataFactory.makeDataItemList(10)

        `when`(dataSource.getItemAll())
            .thenReturn(CompletableDeferred(mockItemList))

        val resultList = repository.getItemAll().await()

        assertEquals(resultList, mockItemList)
    }

    @Ignore("Error exist")
    @Test
    fun getItemAll_withError() = runBlocking {

        val mockError = Throwable("Something error")

        `when`(dataSource.getItemAll())
            .thenThrow(mockError)

        repository.getItemAll().await()

        Unit
    }
}