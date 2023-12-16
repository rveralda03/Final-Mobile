package com.d121211066.alcoholic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211066.alcoholic.data.models.Minum
import com.d121211066.alcoholic.data.repository.DrinkRepository
import com.d121211066.alcoholic.MyApplication
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val alcoholic: List<Minum>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val alcoholicRepo: DrinkRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getDrink() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = alcoholicRepo.getDrinks(
                "Alcoholic"
            )
            mainUiState = MainUiState.Success(result.drinks.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getDrink()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val alcoholicRepository = application.container.drinkRepository
                MainViewModel(alcoholicRepository)
            }
        }
    }
}