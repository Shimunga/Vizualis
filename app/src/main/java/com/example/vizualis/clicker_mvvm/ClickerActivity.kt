package com.example.vizualis.clicker_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vizualis.R
import kotlinx.android.synthetic.main.activity_clicker.*

class ClickerActivity : AppCompatActivity() {

   private lateinit var viewModel: ClickerViewModel
   private lateinit var viewModelFactory: ClickerViewModelFactory

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_clicker)

      viewModelFactory = ClickerViewModelFactory(intent.getIntExtra(CLICKS_EXTRA, 0))
      viewModel = ViewModelProvider(this, viewModelFactory).get(ClickerViewModel::class.java)

      viewModel.clicks.observe(this, Observer { clicksCount->
         incrementedValueTxt.text = "$clicksCount" })
      viewModel.dividableByTen.observe(this, Observer { dividable ->
         if (dividable) {
            Toast.makeText(
               this, "Dividable by zero: " + viewModel.clicks.value
               , Toast.LENGTH_LONG
            ).show()
         }
      })
      incrementBtn.setOnClickListener { incrementClickCount() }
   }

   private fun incrementClickCount(){
     viewModel.increment()
     viewModel.isDivisableByTen()
   }

   companion object {
      const val CLICKS_EXTRA = "com.example.vizualis.clicker_mvvm.ClicksExtra"
   }
}
