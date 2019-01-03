package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.domain.entity.Charm
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class CharmRepositoryImpl(
    private val restService: RestService
) : CharmRepository {

    override fun getCharmAll(): Deferred<List<Charm>> {
        return GlobalScope.async {
            restService.getCharmAll().await()
        }
    }
}