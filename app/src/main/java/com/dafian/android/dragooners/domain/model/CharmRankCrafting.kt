package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharmRankCrafting(
    @JsonProperty("craftable") val isCraftAble: Boolean,
    @JsonProperty("materials") val materialList: List<CraftingCost>
)