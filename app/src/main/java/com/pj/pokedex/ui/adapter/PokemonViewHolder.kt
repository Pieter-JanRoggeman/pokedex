package com.pj.pokedex.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pj.pokedex.R
import com.pj.pokedex.common.loadImageByUrl
import com.pj.pokedex.network.PokemonResults

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val layout_data: View = itemView.findViewById(R.id.layout_data)
    val textView: TextView = itemView.findViewById(R.id.title_pokemon)
    val image_pokemon: ImageView = itemView.findViewById(R.id.image_pokemon)

}