package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.SkillRemoteDataSource
import com.dafian.android.dragooners.util.TestDataFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class SkillRepositoryImplTest {

    private val dataSource = Mockito.mock(SkillRemoteDataSource::class.java)

    private val repository =
        SkillRepositoryImpl(dataSource)

    @Test
    fun getSkillAll_withSuccess() = runBlocking {

        val mockSkillList = TestDataFactory.makeDataSkillList()

        `when`(dataSource.getSkillAll())
            .thenReturn(CompletableDeferred((mockSkillList)))

        val resultList = repository.getSkillAll().await()

        assertEquals(resultList, mockSkillList)
    }

    @Ignore("Error exist")
    @Test
    fun getSkillAll_withError() = runBlocking {

    }
}