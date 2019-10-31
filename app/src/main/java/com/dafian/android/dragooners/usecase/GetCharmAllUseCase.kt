package com.dafian.android.dragooners.usecase

import com.dafian.android.dragooners.domain.model.Charm
import com.dafian.android.dragooners.domain.repository.CharmRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetCharmAllUseCase(
    private val repository: CharmRepository
) {

    fun getCharmAll(): Deferred<List<Charm>> {
        return GlobalScope.async {
            repository.getCharmAll().await()
        }
    }
}