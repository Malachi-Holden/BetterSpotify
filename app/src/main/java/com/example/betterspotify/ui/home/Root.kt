package com.example.betterspotify.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.betterspotify.ui.Home
import com.example.betterspotify.ui.item.ItemView

@Composable
fun Root(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            Home(navController)
        }
        composable("Item/{itemId}") { backStackEntry ->
            ItemView(id = backStackEntry.arguments?.getString("itemId"))
        }
    }
}