package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.domain.entity.Skill
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class SkillRepositoryImpl(
    private val restService: RestService
) : SkillRepository {

    override fun getSkillAll(): Deferred<List<Skill>> {
        return GlobalScope.async {
            restService.getSkillAll().await()
        }
    }
}