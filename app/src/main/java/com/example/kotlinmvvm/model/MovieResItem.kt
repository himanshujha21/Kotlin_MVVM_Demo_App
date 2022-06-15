package com.example.kotlinmvvm.model

import com.google.gson.annotations.SerializedName

data class MovieResItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)