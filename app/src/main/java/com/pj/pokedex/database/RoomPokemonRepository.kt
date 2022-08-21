package com.pj.pokedex.database

import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.repository.RoomRepositoryInterface

class RoomPokemonRepository(private val pokemonDao: RoomPokemonDao) : RoomRepositoryInterface {

    private val pokemonItemConverter = PokemonItemConverter()

    override fun getFavoritePokemonList() : List<Pokemon>{
        return pokemonDao.readAllRoomItems().map {
            pokemonItemConverter.roomPokemonToPokemon(it)
        }
    }

    override suspend fun addFavoritePokemon(pokemon: Pokemon){
        return pokemonDao.addRoomPokemonItem(pokemonItemConverter.pokemonToRoomPokemon(pokemon))
    }

    override fun isPokemonFavorite(id : Int) : Boolean{
        return pokemonDao.isPokemonFavorite(id)
    }

    override suspend fun deletePokemon(pokemon: Pokemon){
        pokemonDao.deletePokemon(pokemonItemConverter.pokemonToRoomPokemon(pokemon))
    }
}