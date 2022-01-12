package com.pj.pokedex.database

import androidx.room.*
import com.pj.pokedex.domain.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRoomPokemonItem(Pokemon: Pokemon)

    @Query("SELECT * FROM favorites_list ORDER BY id ASC")
    fun readAllRoomItems() : List<Pokemon>

    @Query("SELECT EXISTS(SELECT * FROM favorites_list WHERE id = :id)")
    fun isPokemonFavorite(id : Int) : Boolean

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)
}