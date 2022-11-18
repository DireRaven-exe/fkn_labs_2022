package com.fkn.marvelheroapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results (

  @field:Json(name = "id"          ) var id          : String?         = null,
  @field:Json(name = "name"        ) var name        : String?         = null,
  @field:Json(name = "description" ) var description : String?         = null,
  @field:Json(name = "modified"    ) var modified    : String?         = null,
  @field:Json(name = "resourceURI" ) var resourceURI : String?         = null,
  @field:Json(name = "urls"        ) var urls        : List<Urls>      = listOf(),
  @field:Json(name = "thumbnail"   ) var thumbnail   : Thumbnail?      = Thumbnail(),
  @field:Json(name = "comics"      ) var comics      : Comics?         = Comics(),
  @field:Json(name = "stories"     ) var stories     : Stories?        = Stories(),
  @field:Json(name = "events"      ) var events      : Events?         = Events(),
  @field:Json(name = "series"      ) var series      : Series?         = Series()

)