package com.kingdom.plant.data.mapper

import com.kingdom.plant.data.remote.dto.PlantListItemDto
import com.kingdom.plant.domain.model.PlantListItem

fun PlantListItemDto.toPlantListItem(): PlantListItem {
    return PlantListItem(
        name = name,
        scientificName = scientificName,
        family = family,
        imageUrl = imageUrl,
        genus = genus
    )
}