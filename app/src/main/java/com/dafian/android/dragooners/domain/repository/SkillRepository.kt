package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.domain.model.Skill
import kotlinx.coroutines.Deferred

interface SkillRepository {

    fun getSkillAll(): Deferred<List<Skill>>
}