package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.domain.model.Armor
import kotlinx.coroutines.Deferred

interface ArmorRepository {

    fun getArmorAll(): Deferred<List<Armor>>
}