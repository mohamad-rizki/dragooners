package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.domain.model.Weapon
import kotlinx.coroutines.Deferred

interface WeaponRepository {

    fun getWeaponAll(): Deferred<List<Weapon>>
}