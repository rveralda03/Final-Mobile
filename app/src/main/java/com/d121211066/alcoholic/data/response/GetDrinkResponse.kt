package com.d121211066.alcoholic.data.response

import kotlinx.serialization.Serializable
import com.d121211066.alcoholic.data.models.Minum
import kotlinx.serialization.SerialName

@Serializable
class GetDrinkResponse(
    @SerialName("drinks")
    val drinks: List<Minum>?
)