package com.example.betterspotify.model.repository

import com.example.betterspotify.model.HomeModel
import kotlinx.coroutines.delay
import kotlin.random.Random

class HomeRepository {
    val showsErrors = false
    suspend fun fetch(): List<HomeModel>{
        delay(2000)
        if (!showsErrors){
          return content()
        }
        return if (Random.nextInt(5) == 1) throw NetworkError() else content()
    }

    fun content() = List(20){ i ->
        HomeModel(id = i.toString(), title = "Title number $i", content = "Is this the content of $i? Nay.")
    }

    class NetworkError: Exception()
}
