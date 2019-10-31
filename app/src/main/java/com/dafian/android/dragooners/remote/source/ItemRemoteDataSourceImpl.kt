package com.dafian.android.dragooners.remote.source

import com.dafian.android.dragooners.data.source.ItemRemoteDataSource
import com.dafian.android.dragooners.domain.model.Item
import com.dafian.android.dragooners.remote.service.RestService
import kotlinx.coroutines.Deferred

class ItemRemoteDataSourceImpl(
    private val service: RestService
) : ItemRemoteDataSource {

    override fun getItemAll(): Deferred<List<Item>> {
        return service.getItemAll()
    }
}