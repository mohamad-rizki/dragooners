package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Resistances(
    @JsonProperty("fire") val fire: Int,
    @JsonProperty("water") val water: Int,
    @JsonProperty("ice") val ice: Int,
    @JsonProperty("thunder") val thunder: Int,
    @JsonProperty("dragon") val dragon: Int
)