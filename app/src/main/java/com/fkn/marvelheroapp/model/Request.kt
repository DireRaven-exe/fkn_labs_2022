package com.fkn.marvelheroapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Request (

  @field:Json(name = "code"            ) var code            : String? = null,
  @field:Json(name = "status"          ) var status          : String? = null,
  @field:Json(name = "copyright"       ) var copyright       : String? = null,
  @field:Json(name = "attributionText" ) var attributionText : String? = null,
  @field:Json(name = "attributionHTML" ) var attributionHTML : String? = null,
  @field:Json(name = "data"            ) var data            : Data?   = Data(),
  @field:Json(name = "etag"            ) var etag            : String? = null

)