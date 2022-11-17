package com.fkn.marvelheroapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data (

  @field:Json(name = "offset"  ) var offset  : String?            = null,
  @field:Json(name = "limit"   ) var limit   : String?            = null,
  @field:Json(name = "total"   ) var total   : String?            = null,
  @field:Json(name = "count"   ) var count   : String?            = null,
  @field:Json(name = "results" ) var results : List<Results> = listOf()

)