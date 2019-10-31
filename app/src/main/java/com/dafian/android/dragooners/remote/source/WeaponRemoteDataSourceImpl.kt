package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.data.source.WeaponRemoteDataSource
import com.dafian.android.dragooners.domain.model.Weapon
import com.dafian.android.dragooners.remote.service.RestService
import kotlinx.coroutines.Deferred

class WeaponRemoteDataSourceImpl(
    private val service: RestService
) : WeaponRemoteDataSource {

    override fun getWeaponAll(): Deferred<List<Weapon>> {
        return service.getWeaponAll()
    }
}