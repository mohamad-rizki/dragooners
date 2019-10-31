package com.dafian.android.dragooners.usecase

import com.dafian.android.dragooners.domain.model.Skill
import com.dafian.android.dragooners.domain.repository.SkillRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetSkillAllUseCase(
    private val repository: SkillRepository
) {

    fun getSkillAll(): Deferred<List<Skill>> {
        return GlobalScope.async {
            repository.getSkillAll().await()
        }
    }
}