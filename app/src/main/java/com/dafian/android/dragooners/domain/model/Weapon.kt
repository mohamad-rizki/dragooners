package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Weapon(
    @JsonProperty("id") val id: Int,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("rarity") val rarity: Int,
    @JsonProperty("attack") val attack: Any,
    @JsonProperty("slots") val slotList: List<Slot>,
    @JsonProperty("elements") val elementList: List<Any>,
    @JsonProperty("crafting") val crafting: Any,
    @JsonProperty("assets") val weaponAsset: WeaponAsset,
    @JsonProperty("sharpness") val sharpness: Any,
    @JsonProperty("durability") val durability: Any
)