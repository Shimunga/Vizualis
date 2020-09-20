package com.example.vizualis.clicker_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ClickerViewModelFactory(private val initialValue: Int): ViewModelProvider.Factory {

   override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(ClickerViewModel::class.java)) {
         return ClickerViewModel(initialValue) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
   }

}