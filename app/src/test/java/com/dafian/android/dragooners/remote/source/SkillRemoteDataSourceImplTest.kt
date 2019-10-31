package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.remote.service.RestService
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class SkillRemoteDataSourceImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val dataSource = SkillRemoteDataSourceImpl(service)

    @Test
    fun getSkillAll_withSuccess() = runBlocking {

        val mockSkillList = TestDataFactory.makeDataSkillList()

        `when`(service.getSkillAll())
            .thenReturn(CompletableDeferred((mockSkillList)))

        val resultList = dataSource.getSkillAll().await()

        assertEquals(resultList, mockSkillList)
    }
}