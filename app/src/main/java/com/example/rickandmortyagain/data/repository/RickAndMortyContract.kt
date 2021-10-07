package com.example.rickandmortyagain.data.repository

import com.example.rickandmortyagain.models.Info
import kotlinx.coroutines.Deferred

interface RickAndMortyContract {

    suspend fun listCharacterAsync(): Deferred<List<Info>>

}