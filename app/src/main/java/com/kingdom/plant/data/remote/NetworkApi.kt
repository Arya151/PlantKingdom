package com.kingdom.plant.data.remote

import com.kingdom.plant.data.remote.dto.PlantListItemDto
import com.kingdom.plant.data.remote.dto.PlantListResponse
import com.kingdom.plant.util.Resource
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("plants?")
    suspend fun getPlants(
        @Query("token") token : String? = TOKEN
    ) : PlantListResponse


    companion object{
        const val BASE_URL = "https://trefle.io/api/v1/"
        const val TOKEN = "UYQ_MHZkTeZraWd8Er-AXexQNq7RuOY3H75ofvGUN7w"
    }
}