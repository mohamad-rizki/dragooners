package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.domain.entity.Armor
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ArmorRepositoryImpl(
    private val restService: RestService
) : ArmorRepository {

    override fun getArmorAll(): Deferred<List<Armor>> {
        return GlobalScope.async {
            restService.getArmorAll().await()
        }
    }
}