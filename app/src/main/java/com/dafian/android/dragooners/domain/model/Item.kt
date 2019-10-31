package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("rarity") val rarity: Int,
    @JsonProperty("carryLimit") val carryLimit: Int,
    @JsonProperty("sellPrice") val sellPrice: Int,
    @JsonProperty("buyPrice") val buyPrice: Int
)