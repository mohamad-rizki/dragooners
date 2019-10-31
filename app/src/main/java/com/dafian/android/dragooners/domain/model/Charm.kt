package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Charm(
    @JsonProperty("id") val id: Int,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("ranks") val rankList: List<CharmRank>
)