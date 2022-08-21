package com.pj.pokedex.DaoTest

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pj.pokedex.database.PokemonItemConverter
import com.pj.pokedex.database.RoomPokemonDao
import com.pj.pokedex.database.RoomPokemonDatabase
import com.pj.pokedex.domain.model.OfficialArtwork
import com.pj.pokedex.domain.model.Other
import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.domain.model.Sprites
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class RoomPokemonDaoTest {

    private lateinit var database: RoomPokemonDatabase
    private lateinit var dao: RoomPokemonDao
    private val pokemonItemConverter = PokemonItemConverter()

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
            RoomPokemonDatabase::class.java).allowMainThreadQueries().build()
        dao = database.roomPokemonDao()
    }

    @After
    fun shutDown(){
        database.close()
    }

    @Test
    fun insert_PokemonInDatabase() = runBlocking {
        val pokemon = Pokemon(20,
            40,
        1,
        "Bulbasaur",
        Sprites(Other(OfficialArtwork(toString()))),
        buildList { 0 },
        buildList { "grass" },
        12,
        1,
        "a",
        "grass pokemon",
        1,
        "eee")

        dao.addRoomPokemonItem(pokemonItemConverter.pokemonToRoomPokemon(pokemon))
        val pokeList = dao.readAllRoomItems()
        Assert.assertTrue(pokeList.contains(pokemonItemConverter.pokemonToRoomPokemon(pokemon)))
    }
}