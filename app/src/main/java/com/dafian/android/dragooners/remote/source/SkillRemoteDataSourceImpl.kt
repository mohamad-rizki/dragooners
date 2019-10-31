package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.data.source.SkillRemoteDataSource
import com.dafian.android.dragooners.domain.model.Skill
import com.dafian.android.dragooners.remote.service.RestService
import kotlinx.coroutines.Deferred

class SkillRemoteDataSourceImpl(
    private val service: RestService
) : SkillRemoteDataSource {

    override fun getSkillAll(): Deferred<List<Skill>> {
        return service.getSkillAll()
    }
}