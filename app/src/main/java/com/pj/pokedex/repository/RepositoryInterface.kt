package com.pj.pokedex.repository

import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.domain.model.PokemonResults
import com.pj.pokedex.domain.model.PokemonTypeResults
import com.pj.pokedex.domain.model.Species

interface RepositoryInterface {
    suspend fun getPokemon(id: Int): Pokemon
    suspend fun getSpecies(id: Int): Species
    suspend fun getPokemonList(limit: Int): PokemonResults
    suspend fun getPokemonTypeList(type : String) : PokemonTypeResults
}