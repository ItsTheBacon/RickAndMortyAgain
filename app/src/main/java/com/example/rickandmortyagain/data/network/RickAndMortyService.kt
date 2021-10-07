package com.example.rickandmortyagain.data.network

import com.example.rickandmortyagain.data.repository.RickAndMortyDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    fun listCharactersAsync(): Deferred<RickAndMortyDTO>

}