package com.dafian.android.dragooners.data.source

import com.dafian.android.dragooners.domain.model.Charm
import kotlinx.coroutines.Deferred

interface CharmRemoteDataSource {

    fun getCharmAll(): Deferred<List<Charm>>
}