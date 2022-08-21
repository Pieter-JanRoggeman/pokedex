package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.repository.RoomRepositoryInterface

class GetFavoritePokemonListUseCase(private val roomRepositoryInterface: RoomRepositoryInterface) {

    suspend fun getFavoritePokemonList() : List<Pokemon> = roomRepositoryInterface.getFavoritePokemonList()
}