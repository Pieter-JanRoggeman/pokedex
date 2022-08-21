package com.pj.pokedex.database

import com.pj.pokedex.repository.Repository
import com.pj.pokedex.repository.RepositoryInterface
import com.pj.pokedex.repository.RoomRepositoryInterface
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    factory<RepositoryInterface> {  Repository() }
    factory<RoomRepositoryInterface> {  RoomPokemonRepository(RoomPokemonDatabase.getDatabase(androidApplication()).roomPokemonDao()) }
}