package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.repository.RoomRepositoryInterface

class AddFavoritePokemonUseCase(private val roomRepositoryInterface: RoomRepositoryInterface) {

    suspend fun addFavoritePokemon(pokemon : Pokemon){
        roomRepositoryInterface.addFavoritePokemon(pokemon)
    }
}