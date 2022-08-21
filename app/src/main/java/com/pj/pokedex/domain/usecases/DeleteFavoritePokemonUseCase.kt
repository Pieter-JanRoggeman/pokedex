package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.repository.RoomRepositoryInterface

class DeleteFavoritePokemonUseCase(private val roomRepositoryInterface: RoomRepositoryInterface) {

    suspend fun deleteFavoritePokemon(pokemon : Pokemon){
        roomRepositoryInterface.deletePokemon(pokemon)
    }
}