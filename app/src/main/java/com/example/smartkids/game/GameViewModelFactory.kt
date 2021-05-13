package com.example.smartkids.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartkids.TYPES
import java.lang.IllegalArgumentException

class GameViewModelFactory (private val type:TYPES):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GameViewModel::class.java)){
            return GameViewModel(type) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}