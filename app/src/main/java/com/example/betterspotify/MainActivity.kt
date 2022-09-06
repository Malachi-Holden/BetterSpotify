package com.example.betterspotify

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.betterspotify.ui.home.Root
import com.example.betterspotify.ui.theme.BetterSpotifyTheme
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote


class MainActivity : ComponentActivity() {
    var spotifyAppRemote: SpotifyAppRemote? = null
    override fun onStart() {
        val REDIRECT_URI = "com.example.betterspotify" //probably need to register this uri
        val CLIENT_ID = try { resources.getString(R.string.spotifyClientId) } catch (e: Resources.NotFoundException) { "" }
        super.onStart()
        val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(this, connectionParams,
            object : Connector.ConnectionListener {
                override fun onConnected(spotifyAppRemote: SpotifyAppRemote?) {
                    this@MainActivity.spotifyAppRemote = spotifyAppRemote
                }

                override fun onFailure(error: Throwable?) {
                    TODO("Not yet implemented")
                }

            }
            )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterSpotifyTheme {
                Root()
            }
        }
    }
}