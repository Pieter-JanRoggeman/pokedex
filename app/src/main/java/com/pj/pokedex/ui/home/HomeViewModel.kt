package com.pj.pokedex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pj.pokedex.network.ApiResponse
import com.pj.pokedex.network.PokemonApi
import com.pj.pokedex.network.PokemonResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val pokemonList = MutableLiveData<List<PokemonResults>>()

    fun getPokemonList() {

        CoroutineScope(Dispatchers.IO).launch {

            val call = PokemonApi.retrofitService.getPokemon(100, 0)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                    response.body()?.results.let { list ->

                        list?.map {
                            it.name = it.name.capitalize()
                            it.id = it.url.removeSuffix("/").split("/").last()
                        }

                        pokemonList.postValue(list)
                        println(list)
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    call.cancel()
                    println("Api call failed")
                }
            })

        }

    }

}