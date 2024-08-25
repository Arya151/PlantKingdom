package com.kingdom.plant.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlantListResponse(
    val data : List<PlantListItemDto>
)

data class PlantListItemDto(
    @SerializedName("common_name")
    val name: String = "",
    @SerializedName("scientific_name")
    val scientificName: String = "",
    @SerializedName("family")
    val family: String = "",
    @SerializedName("image_url")
    val imageUrl: String = "",
    val genus: String = ""
)
