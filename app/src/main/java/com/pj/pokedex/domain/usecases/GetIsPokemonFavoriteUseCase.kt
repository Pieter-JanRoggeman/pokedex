package com.pj.pokedex.domain.usecases

import com.pj.pokedex.repository.RoomRepositoryInterface

class GetIsPokemonFavoriteUseCase(private val roomRepositoryInterface: RoomRepositoryInterface) {

    fun isPokemonFavorite(id : Int) : Boolean{
        return roomRepositoryInterface.isPokemonFavorite(id)
    }
}