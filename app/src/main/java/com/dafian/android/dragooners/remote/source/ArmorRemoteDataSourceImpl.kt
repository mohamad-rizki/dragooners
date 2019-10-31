package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.data.source.ArmorRemoteDataSource
import com.dafian.android.dragooners.domain.model.Armor
import com.dafian.android.dragooners.remote.service.RestService
import kotlinx.coroutines.Deferred

class ArmorRemoteDataSourceImpl(
    private val service: RestService
) : ArmorRemoteDataSource {

    override fun getArmorAll(): Deferred<List<Armor>> {
        return service.getArmorAll()
    }
}