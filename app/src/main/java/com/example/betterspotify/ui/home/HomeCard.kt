package com.example.betterspotify.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.betterspotify.model.HomeModel

@Composable
fun HomeCard(model: HomeModel, navController: NavController){
    Button(
        onClick = { navController.navigate("Item/${model.id}") },
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = model.title, modifier = Modifier.fillMaxWidth())
            Text(text = model.content, modifier = Modifier.fillMaxWidth())
        }
    }
}