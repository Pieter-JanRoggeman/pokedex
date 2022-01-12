package com.pj.pokedex.domain

import androidx.room.Entity

@Entity(tableName = "favorites_list")
data class Pokemon(
    val name: String,
    val id: Int,
    val url: String,
    var types: ArrayList<String>,
    var abilities: Int,
    var height: Int,
    var weight: Int,
)