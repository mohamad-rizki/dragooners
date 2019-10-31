package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.data.source.CharmRemoteDataSource
import com.dafian.android.dragooners.domain.model.Charm
import com.dafian.android.dragooners.remote.service.RestService
import kotlinx.coroutines.Deferred

class CharmRemoteDataSourceImpl(
    private val service: RestService
) : CharmRemoteDataSource {

    override fun getCharmAll(): Deferred<List<Charm>> {
        return service.getCharmAll()
    }
}