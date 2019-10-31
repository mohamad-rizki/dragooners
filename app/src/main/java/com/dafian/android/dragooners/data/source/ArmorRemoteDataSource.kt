package com.dafian.android.dragooners.data.source

import com.dafian.android.dragooners.domain.model.Armor
import kotlinx.coroutines.Deferred

interface ArmorRemoteDataSource {

    fun getArmorAll(): Deferred<List<Armor>>
}