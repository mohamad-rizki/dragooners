package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.WeaponRemoteDataSource
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class WeaponRepositoryImplTest {

    private val dataSource = Mockito.mock(WeaponRemoteDataSource::class.java)

    private val repository =
        WeaponRepositoryImpl(dataSource)

    @Test
    fun getWeaponAll_withSuccess() = runBlocking {

        val mockWeaponList = TestDataFactory.makeDataWeaponList()

        `when`(dataSource.getWeaponAll())
            .thenReturn(CompletableDeferred(mockWeaponList))

        val resultList = repository.getWeaponAll().await()

        assertEquals(resultList, mockWeaponList)
    }

    @Ignore("Error exist")
    @Test
    fun getWeaponAll_withError() = runBlocking {

    }
}