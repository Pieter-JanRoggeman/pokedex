package com.pj.pokedex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pj.pokedex.domain.Pokemon

/*
* Database entity DatabasePokemon
* This represents a favorited Pokemon in the database
* */

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)

abstract class PokemonDatabase : RoomDatabase() {

    abstract fun roomPokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getDatabase(context: Context): PokemonDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDatabase::class.java,
                    "pokemon_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

