package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class SkillRank(
    @JsonProperty("id") val id: Int,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("skill") val skill: Int,
    @JsonProperty("level") val level: Int,
    @JsonProperty("description") val description: String
)