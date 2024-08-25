package com.kingdom.plant.presentation.home

import com.kingdom.plant.domain.model.PlantListItem

data class PlantListState (
    var isLoading : Boolean = false,
    var plantList : List<PlantListItem> = emptyList()
)