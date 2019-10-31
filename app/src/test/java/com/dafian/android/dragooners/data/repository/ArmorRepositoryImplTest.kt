package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.ArmorRemoteDataSource
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ArmorRepositoryImplTest {

    private val dataSource = Mockito.mock(ArmorRemoteDataSource::class.java)

    private val repository =
        ArmorRepositoryImpl(dataSource)

    @Test
    fun getArmorAll_withSuccess() = runBlocking {

        val mockArmorList = TestDataFactory.makeDataArmorList(10)

        `when`(dataSource.getArmorAll())
            .thenReturn(CompletableDeferred(mockArmorList))

        val resultList = repository.getArmorAll().await()

        assertEquals(resultList, mockArmorList)
    }

    @Ignore("Error Exist")
    @Test
    fun getArmorAll_withError() = runBlocking {

        val mockError = Throwable("Something error")

        `when`(dataSource.getArmorAll())
            .thenThrow(mockError)

        repository.getArmorAll().await()

        Unit
    }
}