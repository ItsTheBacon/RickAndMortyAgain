package com.example.rickandmortyagain.ui.useCase

import com.example.rickandmortyagain.data.repository.RickAndMortyRepository

class RickAndMortyUseCase(private val repository: RickAndMortyRepository) {

    suspend fun getCharacterAsync() = repository.listCharacterAsync()
}