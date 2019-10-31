package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.CharmRemoteDataSource
import com.dafian.android.dragooners.domain.model.Charm
import com.dafian.android.dragooners.domain.repository.CharmRepository
import kotlinx.coroutines.Deferred

class CharmRepositoryImpl(
    private val dataSource: CharmRemoteDataSource
) : CharmRepository {

    override fun getCharmAll(): Deferred<List<Charm>> {
        return dataSource.getCharmAll()
    }
}