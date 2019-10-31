package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CraftingCost(
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("item") val item: Item
)