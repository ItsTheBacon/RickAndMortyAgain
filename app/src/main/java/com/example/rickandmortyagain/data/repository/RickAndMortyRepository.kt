package com.example.rickandmortyagain.data.repository

import com.example.rickandmortyagain.data.network.RickAndMortyService
import com.example.rickandmortyagain.models.Info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class RickAndMortyRepository(private val service: RickAndMortyService) : RickAndMortyContract {
    override suspend fun listCharacterAsync() =
        withContext(Dispatchers.IO) {
            async {
                service.fetchCharactersAsync().await().results.map {
                    Info(it.name, it.image)
                }
            }
        }


}