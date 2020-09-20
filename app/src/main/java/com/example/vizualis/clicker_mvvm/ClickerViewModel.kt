package com.example.vizualis.clicker_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickerViewModel(private val initialValue: Int): ViewModel() {

   private val _clicks = MutableLiveData<Int>()
   val clicks: LiveData<Int>
      get() = _clicks

   private val _dividableByTen = MutableLiveData<Boolean>()
   val dividableByTen: LiveData<Boolean>
      get() = _dividableByTen

   init {
     _clicks.value  = initialValue
     _dividableByTen.value = false
   }

   fun increment(){
      _clicks.value = _clicks.value?.inc()

   }

   fun isDivisableByTen(){
      _dividableByTen.value = _clicks.value?.rem(10) == 0
   }

}