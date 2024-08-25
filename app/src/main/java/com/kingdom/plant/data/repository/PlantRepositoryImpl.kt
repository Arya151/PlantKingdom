package com.kingdom.plant.data.repository

import com.kingdom.plant.data.mapper.toPlantListItem
import com.kingdom.plant.data.remote.NetworkApi
import com.kingdom.plant.domain.model.PlantListItem
import com.kingdom.plant.domain.repository.PlantRepository
import com.kingdom.plant.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PlantRepositoryImpl(
    private val networkApi: NetworkApi
) : PlantRepository {

    override suspend fun getPlantList(): Flow<Resource<List<PlantListItem>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                emit(
                    Resource.Success(
                        networkApi.getPlants()?.data?.map { it.toPlantListItem() }
                    )
                )
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Failed to load plants"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Failed to load plants"))
            }
        }
    }

}