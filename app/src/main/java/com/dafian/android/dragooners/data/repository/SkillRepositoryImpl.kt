package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.SkillRemoteDataSource
import com.dafian.android.dragooners.domain.model.Skill
import com.dafian.android.dragooners.domain.repository.SkillRepository
import kotlinx.coroutines.Deferred

class SkillRepositoryImpl(
    private val dataSource: SkillRemoteDataSource
) : SkillRepository {

    override fun getSkillAll(): Deferred<List<Skill>> {
        return dataSource.getSkillAll()
    }
}