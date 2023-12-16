package com.d121211066.alcoholic.data.source.remote

import com.d121211066.alcoholic.data.response.GetDrinkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/json/v1/1/filter.php")
    suspend fun getMinum(
        @Query("a") a: String
    ): GetDrinkResponse

}