package com.example.rickandmortyagain.data.repository

import com.example.rickandmortyagain.models.Info


data class RickAndMortyDTO(
    val info: Info,
    val results: List<Results>
)


data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)

data class Results(
    val info: Info,
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class Origin(
    val name: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)