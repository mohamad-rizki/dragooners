package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.CharmRemoteDataSource
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class CharmRepositoryImplTest {

    private val dataSource = Mockito.mock(CharmRemoteDataSource::class.java)

    private val repository =
        CharmRepositoryImpl(dataSource)

    @Test
    fun getCharmAll_withSuccess() = runBlocking {

        val mockCharmList = TestDataFactory.makeDataCharmList()

        `when`(dataSource.getCharmAll())
            .thenReturn(CompletableDeferred(mockCharmList))

        val resultList = repository.getCharmAll().await()

        assertEquals(resultList, mockCharmList)
    }

    @Ignore("Error exist")
    @Test
    fun getCharmAll_withError() = runBlocking {

    }
}