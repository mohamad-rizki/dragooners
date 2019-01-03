package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class CharmRank(
    @JsonProperty("name") val name: String,
    @JsonProperty("level") val level: Int,
    @JsonProperty("rarity") val rarity: Int,
    @JsonProperty("skills") val skillList: List<Any>,
    @JsonProperty("crafting") val crafting: CharmRankCrafting
)