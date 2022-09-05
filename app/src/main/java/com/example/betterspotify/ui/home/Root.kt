package com.example.betterspotify.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.betterspotify.ui.Home
import com.example.betterspotify.ui.item.ItemView
import com.example.betterspotify.viewModel.HomeViewModel

@Composable
fun Root(){
    val navController = rememberNavController()
    val viewModel: HomeViewModel = viewModel()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            Home(navController, viewModel)
        }
        composable("Item/{itemId}") { backStackEntry ->
            ItemView(id = backStackEntry.arguments?.getString("itemId"), viewModel)
        }
    }
}