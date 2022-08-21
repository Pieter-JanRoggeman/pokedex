package com.pj.pokedex.domain.model

import com.google.gson.annotations.SerializedName
import com.pj.pokedex.domain.model.OfficialArtwork
import java.io.Serializable

data class Other(
    @SerializedName("official-artwork") val official_artwork: OfficialArtwork
) : Serializable