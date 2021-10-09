package com.example.rickandmortyagain.servicelocator

import com.example.rickandmortyagain.data.network.RickAndMortyService
import com.example.rickandmortyagain.data.network.retrofit.initRetrofit
import com.example.rickandmortyagain.data.repository.RickAndMortyRepository
import com.example.rickandmortyagain.ui.fragments.character.CharacterViewModel
import com.example.rickandmortyagain.ui.useCase.RickAndMortyUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val rickMortyModules = module {
    single { RickAndMortyRepository(get()) }
    single { RickAndMortyUseCase(get()) }
    single { initRetrofit() }
    single { get<Retrofit>().create(RickAndMortyService::class.java) }
    viewModel { CharacterViewModel(get()) }
}