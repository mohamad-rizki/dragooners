package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Slot(
    @JsonProperty("rank") val rank: Int
)