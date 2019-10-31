package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.ArmorRemoteDataSource
import com.dafian.android.dragooners.domain.model.Armor
import com.dafian.android.dragooners.domain.repository.ArmorRepository
import kotlinx.coroutines.Deferred

class ArmorRepositoryImpl(
    private val dataSource: ArmorRemoteDataSource
) : ArmorRepository {

    override fun getArmorAll(): Deferred<List<Armor>> {
        return dataSource.getArmorAll()
    }
}