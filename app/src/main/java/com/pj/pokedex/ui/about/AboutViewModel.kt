package com.pj.pokedex.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the about Fragment"
    }
    val text: LiveData<String> = _text

    fun setText(text: String){
        _text.value=text;
    }
}