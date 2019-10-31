package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.WeaponRemoteDataSource
import com.dafian.android.dragooners.domain.model.Weapon
import com.dafian.android.dragooners.domain.repository.WeaponRepository
import kotlinx.coroutines.Deferred

class WeaponRepositoryImpl(
    private val dataSource: WeaponRemoteDataSource
) : WeaponRepository {

    override fun getWeaponAll(): Deferred<List<Weapon>> {
        return dataSource.getWeaponAll()
    }
}