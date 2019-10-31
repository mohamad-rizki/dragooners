package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CraftingInfo(
    @JsonProperty("materials") val materialList: List<CraftingCost>
)