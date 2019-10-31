package com.dafian.android.dragooners.data.source

import com.dafian.android.dragooners.domain.model.Weapon
import kotlinx.coroutines.Deferred

interface WeaponRemoteDataSource {

    fun getWeaponAll(): Deferred<List<Weapon>>
}