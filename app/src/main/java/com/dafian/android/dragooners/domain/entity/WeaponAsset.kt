package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class WeaponAsset(
    @JsonProperty("icon") val urlIcon: String,
    @JsonProperty("image") val urlImage: String
)