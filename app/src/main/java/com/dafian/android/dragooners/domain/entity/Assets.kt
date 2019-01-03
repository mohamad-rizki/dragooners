package com.dafian.android.dragooners.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Assets(
    @JsonProperty("imageMale") val urlImageMale: String?,
    @JsonProperty("imageFemale") val urlImageFemale: String?
)