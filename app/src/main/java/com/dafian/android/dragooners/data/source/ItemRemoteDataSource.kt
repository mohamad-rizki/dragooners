package com.dafian.android.dragooners.data.source

import com.dafian.android.dragooners.domain.model.Item
import kotlinx.coroutines.Deferred

interface ItemRemoteDataSource {

    fun getItemAll(): Deferred<List<Item>>
}