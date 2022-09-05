package com.example.betterspotify.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.betterspotify.model.HomeModel
import com.example.betterspotify.ui.HomeCard

@Composable
fun HomeView(data: List<HomeModel>, navController: NavController){
    LazyColumn {
        item {
            Box(modifier = Modifier.height(10.dp))
        }
        items(data) { model ->
            HomeCard(model, navController)
        }
    }
}