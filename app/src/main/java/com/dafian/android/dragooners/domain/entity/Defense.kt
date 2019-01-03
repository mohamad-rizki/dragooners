package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Defense(
    @JsonProperty("base") val base: Int,
    @JsonProperty("max") val max: Int,
    @JsonProperty("augmented") val augmented: Int
)