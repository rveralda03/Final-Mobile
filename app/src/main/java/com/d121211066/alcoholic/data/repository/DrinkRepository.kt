package com.d121211066.alcoholic.data.repository

import com.d121211066.alcoholic.data.response.GetDrinkResponse
import com.d121211066.alcoholic.data.source.remote.ApiService

class DrinkRepository(private val apiService: ApiService) {

    suspend fun getDrinks(a: String): GetDrinkResponse {
        return apiService.getMinum(a)
    }

}