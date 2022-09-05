package com.example.betterspotify.ui.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.betterspotify.model.HomeModel
import com.example.betterspotify.ui.EmptyState
import com.example.betterspotify.ui.ErrorState
import com.example.betterspotify.ui.LoadingState
import com.example.betterspotify.viewModel.HomeUIState
import com.example.betterspotify.viewModel.HomeViewModel

@Composable
fun ItemView(id: String?, viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    val uiState = viewModel.uiState.collectAsState().value
    when(uiState){
        is HomeUIState.Loading -> LoadingState()
        is HomeUIState.Error -> ErrorState(error = uiState)
        is HomeUIState.Loaded -> {
            if (uiState.data.isEmpty()) {
                EmptyState()
            }
            else {
                val item = uiState.data.first { it.id == id }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = item.title)
                    Text(text = item.content)
                }
            }
        }
    }

}
