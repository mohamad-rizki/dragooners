package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.remote.service.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ArmorRemoteDataSourceImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val dataSource = ArmorRemoteDataSourceImpl(service)

    @Test
    fun getArmorAll_withSuccess() = runBlocking {

        val mockArmorList = TestDataFactory.makeDataArmorList(10)

        `when`(service.getArmorAll())
            .thenReturn(CompletableDeferred(mockArmorList))

        val resultList = dataSource.getArmorAll().await()

        assertEquals(resultList, mockArmorList)
    }
}