package com.pj.pokedex.ui.adapter

import com.pj.pokedex.R
import com.pj.pokedex.domain.Pokemon

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PokemonAdapter(
    dataSet: List<Pokemon>
) : RecyclerView.Adapter<PokemonViewHolder>(), Filterable {

    private var dataSetAll: MutableList<Pokemon> = dataSet.toMutableList()
    private var dataSetFilter: MutableList<Pokemon> = dataSet.toMutableList()
    private var dataSetFavorites: MutableList<Pokemon> = dataSet.toMutableList()

    var onCallBackDataSetFilterSize: ((size: Int) -> Unit)? = null
    var onCallBackDataSetFilterRemove: ((size: Int, position: Int) -> Unit)? = null
    var onCallBackClickDetail: ((url: String) -> Unit)? = null

    private var char_sequence: CharSequence = ""
    private var favorites_filter = false
    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_viewholder, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val name = dataSetFilter[position].name
        holder.textView.text = name.lowercase().replaceFirstChar(Char::uppercase)
        setImage(name, holder)
        detail(dataSetFilter[position].url, name, holder)
    }

    private fun getIsFavorite(name: String): Boolean {
        val sharedPref = view.context.getSharedPreferences(FAVORITES, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(name, false)
    }

    private fun setPreferences(name: String, value: Boolean) {
        val sharedPref = view.context.getSharedPreferences(FAVORITES, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(name, value)
            commit()
        }
    }

    private fun setImage(name: String, holder: PokemonViewHolder) {
        val url_image = "https://img.pokemondb.net/artwork/${name.lowercase()}.jpg"
        Picasso.get()
            .load(url_image)
            .error(R.drawable.ic_error_image)
            .into(holder.image_pokemon)
    }

    private fun detail(url: String?, name: String, holder: PokemonViewHolder) {
        holder.layout_data.setOnClickListener {
            url?.let { url -> onCallBackClickDetail?.invoke(url) }
        }
    }

    override fun getItemCount() = dataSetFilter.size

    fun getFavorites(filter: Boolean) {
        val sharedPreferences = view.context.getSharedPreferences(FAVORITES, Context.MODE_PRIVATE)
        val favorites = sharedPreferences.all.filter { it.value == true }.map { it.key }
        val filteredList = mutableListOf<Pokemon>()
        if (filter) {
            favorites_filter = filter
            dataSetAll.forEach { pokemon ->
                if (pokemon.name.lowercase() in favorites) {
                    filteredList.add(pokemon)
                }
            }
            dataSetFilter.clear()
            dataSetFavorites.clear()
            dataSetFilter.addAll(filteredList)
            dataSetFavorites.addAll(filteredList)
            getFilter().filter(char_sequence)
        } else {
            favorites_filter = filter
            dataSetFilter.clear()
            dataSetFavorites.clear()
            dataSetFilter.addAll(dataSetAll)
            getFilter().filter(char_sequence)
        }
        onCallBackDataSetFilterSize?.invoke(dataSetFilter.size)
    }

    fun setCharSequence(char: CharSequence?) {
        char?.let {
            char_sequence = it
        }
    }

    override fun getFilter(): Filter {
        return filterVal
    }

    private fun filterSearchAndIsFavorite(
        char_sequence: CharSequence?,
        dataSet: MutableList<Pokemon>,
        filteredList: MutableList<Pokemon>
    ): MutableList<Pokemon> {
        if (char_sequence.toString().lowercase().isEmpty()) {
            filteredList.addAll(dataSet)
        } else {
            dataSet.forEach { pokemon ->
                if (pokemon.name.lowercase().contains(char_sequence.toString().lowercase())) {
                    filteredList.add(pokemon)
                }
            }
        }
        return filteredList
    }

    private val filterVal = object : Filter() {
        // Run on background thread
        override fun performFiltering(char_sequence: CharSequence?): FilterResults {
            var filteredList = mutableListOf<Pokemon>()

            filteredList = if (favorites_filter) {
                if (dataSetFilter.isEmpty()) {
                    filterSearchAndIsFavorite(char_sequence, dataSetFavorites, filteredList)
                } else {
                    filterSearchAndIsFavorite(char_sequence, dataSetFavorites, filteredList)
                }
            } else {
                filterSearchAndIsFavorite(char_sequence, dataSetAll, filteredList)
            }

            val filterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(char_sequence: CharSequence?, filter_results: FilterResults?) {
            dataSetFilter.clear()
            filter_results?.values?.let { values ->
                dataSetFilter.addAll(values as Collection<Pokemon>)
                onCallBackDataSetFilterSize?.invoke(dataSetFilter.size)
            }
        }
    }

    companion object {
        const val FAVORITES = "FAVORITES"
    }

}
