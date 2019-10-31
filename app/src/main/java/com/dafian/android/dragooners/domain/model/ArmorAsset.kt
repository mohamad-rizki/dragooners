package com.dafian.android.dragooners.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ArmorAsset(
    @JsonProperty("imageMale") val urlMale: String?,
    @JsonProperty("imageFemale") val urlFemale: String?
)