package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.PokemonResults
import com.pj.pokedex.repository.RepositoryInterface

class GetAllPokemonNamesUseCase(private val repository: RepositoryInterface) {
    suspend fun getAllPokemonNames(limit: Int): PokemonResults = repository.getPokemonList(limit)
}