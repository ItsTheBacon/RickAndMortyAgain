package com.example.rickandmortyagain.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    val image: String,


    )