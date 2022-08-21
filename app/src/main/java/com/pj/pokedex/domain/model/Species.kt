package com.pj.pokedex.domain.model

import com.pj.pokedex.domain.model.FlavorTextEntry
import java.io.Serializable

data class Species(
    var flavor_text_entries: List<FlavorTextEntry>,
    var capture_rate : Int
) : Serializable