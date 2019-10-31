package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.remote.service.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class WeaponRemoteDataSourceImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val dataSource = WeaponRemoteDataSourceImpl(service)

    @Test
    fun getWeaponAll_withSuccess() = runBlocking {

        val mockWeaponList = TestDataFactory.makeDataWeaponList()

        `when`(service.getWeaponAll())
            .thenReturn(CompletableDeferred(mockWeaponList))

        val resultList = dataSource.getWeaponAll().await()

        assertEquals(resultList, mockWeaponList)
    }
}