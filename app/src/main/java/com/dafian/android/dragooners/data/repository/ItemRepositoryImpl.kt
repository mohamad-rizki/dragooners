package com.dafian.android.dragooners.data.repository

import com.dafian.android.dragooners.data.source.ItemRemoteDataSource
import com.dafian.android.dragooners.domain.model.Item
import com.dafian.android.dragooners.domain.repository.ItemRepository
import kotlinx.coroutines.Deferred

class ItemRepositoryImpl(
    private val dataSource: ItemRemoteDataSource
) : ItemRepository {

    override fun getItemAll(): Deferred<List<Item>> {
        return dataSource.getItemAll()
    }
}