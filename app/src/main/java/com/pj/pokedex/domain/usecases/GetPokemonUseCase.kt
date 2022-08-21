package com.pj.pokedex.domain.usecases

import com.pj.pokedex.domain.model.FlavorTextEntry
import com.pj.pokedex.domain.model.Pokemon
import com.pj.pokedex.repository.RepositoryInterface

class GetPokemonUseCase(private val repository: RepositoryInterface) {

    suspend fun getPokemon(id: Int): Pokemon {
        val pokemon = repository.getPokemon(id)
        val species = repository.getSpecies(id)
        pokemon.description = getPokemonDescription(species.flavor_text_entries)
        pokemon.capture_rate = species.capture_rate
        return pokemon
    }

    private fun getPokemonDescription(flavorTextList: List<FlavorTextEntry>): String {
        var index = flavorTextList.size - 1
        var flavorText = flavorTextList[index].flavor_text
        flavorText = flavorText.replace("POKéMON", "Pokémon")
        flavorText = flavorText.replace("\n", " ")
        return flavorText
    }
}