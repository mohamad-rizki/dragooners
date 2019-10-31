package com.dafian.android.dragooners.data.source

import com.dafian.android.dragooners.domain.model.Skill
import kotlinx.coroutines.Deferred

interface SkillRemoteDataSource {

    fun getSkillAll(): Deferred<List<Skill>>
}