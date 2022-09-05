package com.example.betterspotify.ui

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.betterspotify.ui.home.HomeView
import com.example.betterspotify.viewModel.HomeUIState
import com.example.betterspotify.viewModel.HomeViewModel

@Composable
fun Home(navController: NavController, viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    when (val viewState = viewModel.uiState.collectAsState().value){
        is HomeUIState.Error -> ErrorState(viewState)
        is HomeUIState.Loading -> LoadingState()
        is HomeUIState.Loaded -> {
            if (viewState.data.isEmpty()){
                EmptyState()
            }
            else{
                HomeView(viewState.data, navController)
            }
        }
    }
}

@Composable
fun ErrorState(error: HomeUIState.Error){
    Text(text = error.message)
}

@Composable
fun LoadingState(){
    CircularProgressIndicator()
}

@Composable
fun EmptyState(){
    Text(text = "Nothing to show!")

}