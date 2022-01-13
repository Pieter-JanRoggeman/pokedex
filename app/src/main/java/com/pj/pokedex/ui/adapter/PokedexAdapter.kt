package com.pj.pokedex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pj.pokedex.R
import com.pj.pokedex.network.PokemonResults

class PokedexAdapter() : RecyclerView.Adapter<PokedexViewHolder>(){

    private var pokemonList: List<PokemonResults> = emptyList()
    fun setData(list: List<PokemonResults>){
        pokemonList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_pokemon, parent, false)
        return PokedexViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int = pokemonList.size


}