package com.pj.pokedex.repository

import com.pj.pokedex.database.api.RetrofitInstance
import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.domain.model.PokemonResults
import com.pj.pokedex.domain.model.PokemonTypeResults
import com.pj.pokedex.domain.model.Species

class Repository : RepositoryInterface {
    override suspend fun getPokemon(id: Int): Pokemon {
        return RetrofitInstance.api.getPokemon(id)
    }

    override suspend fun getSpecies(id: Int): Species {
        return RetrofitInstance.api.getSpecies(id)
    }

    override suspend fun getPokemonList(limit: Int): PokemonResults {
        return RetrofitInstance.api.getPokemonList(limit)
    }

    override suspend fun getPokemonTypeList(type : String) : PokemonTypeResults {
        return RetrofitInstance.api.getPokemonTypeList(type)
    }
}