package com.pj.pokedex.domain

import androidx.room.Entity
import com.pj.pokedex.domain.pokemonDetails.*

@Entity(tableName = "favorites_list")
data class Pokemon(
    var id: Int?,
    var name: String,
    var url: String?,
    var height: Int?,
    var weight: Int?,
    var base_experience: Int?,
    var stats: List<Stat>?,
    var types: List<Type>?,
    var abilities: List<Abilities>?,
    var sprites: Sprites,
    var encounters: List<Location>,
    var evolution: EvolutionChain,
    var characteristic: Characteristic?,
    var specie: Specie
)



data class Stat(
    var base_stat: Int,
    var effort: Int,
    var stat: Default
)

data class Type(
    var slot: Int,
    var type: Default,
)

data class Abilities(
    var is_hidden: Boolean,
    var slot: Int,
    var ability: Default
)

data class Sprites(
    var back_default: String,
    var back_female: String?,
    var back_shiny: String,
    var back_shiny_female: String?,
    var front_default: String,
    var front_female: String?,
    var front_shiny: String,
    var front_shiny_female: String?,
)

data class Location (
    val location_area: Default,
    val version_details: List<VersionDetails>
)

data class VersionDetails (
    val encounter_details: List<EncounterDetails>,
    val max_chance: Int,
    val version: Default
)

data class EncounterDetails (
    val chance: Int,
    val max_level: Int,
    val method: Default,
    val min_level: Int
)

data class EvolutionChain(
    val chain: Chain,
    val baby_trigger_item: Default?,
    val id: Int
)

data class Chain (
    val is_baby: Boolean,
    val species: Default?,
    val evolution_details: List<EvolutionDetails>?,
    val evolves_to: List<Chain>?
)

data class EvolutionDetails (
    val gender: Int?,
    val min_affection: Int?,
    val min_beauty: Int?,
    val min_happiness: Int?,
    val min_level: Int?,
    val needs_overworld_rain: Boolean?,
    val relative_physical_stats: Int?,
    val time_of_day: String?,
    val trigger: Default,
    val turn_upside_down: Boolean?
)

data class Characteristic (
    val descriptions: List<Description>,
    val gene_modulo: Int,
    val highest_stat: Default,
    val id: Int,
    val possible_values: List<Int>
)

data class Description (
    val description: String,
    val language: Default
)

data class PalParkEncounters (
    val area: Default,
    val base_score: Int,
    val rate: Int
)

data class PokedexNumbers (
    val entry_number: Int,
    val pokedex: Default
)

data class Varieties (
    val is_default: Boolean,
    val pokemon: Default
)

data class FlavorText (
    val flavor_text: String,
    val language: Default,
    val version: Default
)

data class Specie (
    val base_happiness: Int,
    val capture_rate: Int,
    val color: Default,
    val egg_groups: List<Default>,
    val evolution_chain: Default,
    val evolves_from_species: Default,
    val flavor_text_entries: List<FlavorText>,
    val forms_switchable: Boolean,
    val gender_rate: Int,
    val generation: Default,
    val growth_rate: Default,
    val habitat: Default?,
    val has_gender_differences: Boolean,
    val hatch_counter: Int,
    val id: Int,
    val is_baby: Boolean,
    val is_legendary: Boolean,
    val is_mythical: Boolean,
    val name: String,
    val order: Int,
    val pal_park_encounters: List<PalParkEncounters>,
    val pokedex_numbers: List<PokedexNumbers>,
    val shape: Default,
    val varieties: List<Varieties>
)

