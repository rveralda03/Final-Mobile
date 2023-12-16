package com.d121211066.alcoholic.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Minum(
    val strDrink: String?,
    val strDrinkThumb: String?,
    val idDrink: String?
) : Parcelable