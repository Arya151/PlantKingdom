package com.kingdom.plant.domain.repository

import com.kingdom.plant.domain.model.PlantListItem
import com.kingdom.plant.util.Resource
import kotlinx.coroutines.flow.Flow

interface PlantRepository {

    suspend fun getPlantList() : Flow<Resource<List<PlantListItem>>>

}