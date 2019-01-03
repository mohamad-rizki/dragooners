package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.domain.entity.Weapon
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class WeaponRepositoryImpl(
    private val restService: RestService
) : WeaponRepository {

    override fun getWeaponAll(): Deferred<List<Weapon>> {
        return GlobalScope.async {
            restService.getWeaponAll().await()
        }
    }
}