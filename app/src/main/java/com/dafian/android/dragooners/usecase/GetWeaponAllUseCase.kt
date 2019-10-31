package com.dafian.android.dragooners.usecase

import com.dafian.android.dragooners.domain.model.Weapon
import com.dafian.android.dragooners.domain.repository.WeaponRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetWeaponAllUseCase(
    private val repository: WeaponRepository
) {

    fun getWeaponAll(): Deferred<List<Weapon>> {
        return GlobalScope.async {
            repository.getWeaponAll().await()
        }
    }
}