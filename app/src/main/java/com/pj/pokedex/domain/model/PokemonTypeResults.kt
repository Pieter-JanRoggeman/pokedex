package com.pj.pokedex.domain.model


import com.google.gson.annotations.SerializedName

data class PokemonTypeResults(@SerializedName("pokemon") val results: List<TypePokemon>)