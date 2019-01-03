package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.domain.entity.Item
import kotlinx.coroutines.Deferred

interface ItemRepository {

    fun getItemAll(): Deferred<List<Item>>
}