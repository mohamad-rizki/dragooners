package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.domain.entity.Charm
import kotlinx.coroutines.Deferred

interface CharmRepository {

    fun getCharmAll(): Deferred<List<Charm>>
}