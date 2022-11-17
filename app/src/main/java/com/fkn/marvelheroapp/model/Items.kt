package com.fkn.marvelheroapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Items (

  @field:Json(name = "resourceURI" ) var resourceURI : String? = null,
  @field:Json(name = "name"        ) var name        : String? = null

)