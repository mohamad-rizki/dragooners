package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Skill(
    @JsonProperty("id") val id: Int,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("level") val level: Int,
    @JsonProperty("description") val description: String,
    @JsonProperty("modifiers") val modifierList: List<Any>,
    @JsonProperty("skill") val skill: Int,
    @JsonProperty("skillName") val skillName: String
)