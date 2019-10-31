package com.dafian.android.dragooners.usecase

import com.dafian.android.dragooners.domain.model.Item
import com.dafian.android.dragooners.domain.repository.ItemRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetItemAllUseCase(
    private val repository: ItemRepository
) {

    fun getItemAll(): Deferred<List<Item>> {
        return GlobalScope.async {
            repository.getItemAll().await()
        }
    }
}