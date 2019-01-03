package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Armor(
    @JsonProperty("id") val id: Int,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("rank") val rank: String,
    @JsonProperty("rarity") val rarity: Int,
    @JsonProperty("defense") val defense: Defense,
    @JsonProperty("resistances") val resistances: Resistances,
    @JsonProperty("slots") val slotList: List<Slot>,
    @JsonProperty("skills") val skillList: List<Skill>,
    @JsonProperty("assets") val assets: Assets,
    @JsonProperty("crafting") val crafting: CraftingInfo
)