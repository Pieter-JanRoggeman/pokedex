package com.pj.pokedex.domain

import com.pj.pokedex.domain.usecases.*
import org.koin.dsl.module

val domainModule = module {
    factory { GetPokemonUseCase(get()) }
    factory { AddFavoritePokemonUseCase(get()) }
    factory { DeleteFavoritePokemonUseCase(get()) }
    factory { GetFavoritePokemonListUseCase(get()) }
    factory { GetIsPokemonFavoriteUseCase(get()) }
    factory { GetAllPokemonNamesUseCase(get()) }
    factory { GetAllPokemonOfTypeUseCase(get()) }
}