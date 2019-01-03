package com.dafian.android.dragooners.domain.repository

import com.dafian.android.dragooners.data.network.RestService
import com.dafian.android.dragooners.domain.entity.Item
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ItemRepositoryImpl(
    private val restService: RestService
) : ItemRepository {

    override fun getItemAll(): Deferred<List<Item>> {
        return GlobalScope.async {
            restService.getItemAll().await()
        }
    }
}