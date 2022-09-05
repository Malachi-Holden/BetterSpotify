package com.example.betterspotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.betterspotify.ui.home.Root
import com.example.betterspotify.ui.theme.BetterSpotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterSpotifyTheme {
                Root()
            }
        }
    }
}