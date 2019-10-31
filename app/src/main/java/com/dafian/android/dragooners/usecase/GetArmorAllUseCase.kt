package com.dafian.android.dragooners.usecase

import com.dafian.android.dragooners.domain.model.Armor
import com.dafian.android.dragooners.domain.repository.ArmorRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetArmorAllUseCase(
    private val repository: ArmorRepository
) {

    fun getArmorAll(): Deferred<List<Armor>> {
        return GlobalScope.async {
            repository.getArmorAll().await()
        }
    }
}