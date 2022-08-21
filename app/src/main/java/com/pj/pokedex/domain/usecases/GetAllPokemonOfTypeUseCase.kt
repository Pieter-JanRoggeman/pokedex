package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.PokemonTypeResults
import com.pj.pokedex.repository.RepositoryInterface

class GetAllPokemonOfTypeUseCase(private val repository: RepositoryInterface) {
    suspend fun getAllPokemonOfType(type: String): PokemonTypeResults = repository.getPokemonTypeList(type)
}