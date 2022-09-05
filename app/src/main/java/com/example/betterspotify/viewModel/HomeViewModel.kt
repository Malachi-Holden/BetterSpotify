package com.example.betterspotify.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betterspotify.model.HomeModel
import com.example.betterspotify.model.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(val respository: HomeRepository = HomeRepository()): ViewModel() {
    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loaded(listOf()))
    val uiState: StateFlow<HomeUIState> = _uiState

    init {
        fetchHome()
    }

    fun fetchHome(){
        _uiState.value = HomeUIState.Loading
        viewModelScope.launch{
            while (true){
                try{
                    val response = respository.fetch()
                    _uiState.value = HomeUIState.Loaded(response)
                }
                catch (e: HomeRepository.NetworkError){
                    _uiState.value = HomeUIState.Error("big ol error")
                }
            }

        }
    }
}

sealed class HomeUIState {
    object Loading: HomeUIState()
    class Loaded(val data: List<HomeModel>): HomeUIState()
    class Error(val message: String): HomeUIState()
}