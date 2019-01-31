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

class SkillRepositoryImplTest {

    private val service = Mockito.mock(RestService::class.java)

    private val repository = SkillRepositoryImpl(service)

    @Test
    fun getSkillAll_withSuccess() = runBlocking {

        val mockSkillList = TestDataFactory.makeDataSkillList()

        `when`(service.getSkillAll())
            .thenReturn(CompletableDeferred((mockSkillList)))

        val resultList = repository.getSkillAll().await()

        assertEquals(resultList, mockSkillList)
    }

    @Ignore
    @Test
    fun getSkillAll_withError() = runBlocking {

    }
}