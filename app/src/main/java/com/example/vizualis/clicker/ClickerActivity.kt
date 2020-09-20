package com.example.vizualis.clicker

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.vizualis.R
import kotlinx.android.synthetic.main.activity_clicker.*

class ClickerActivity : AppCompatActivity() {
   private var clicks = 0

   companion object {
      const val TAG = "Clickerctivity"
      const val CLICKS_EXTRA = "ClicksExtra"
   }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_clicker)

      clicks = getPreferences(Application.MODE_PRIVATE)
         .getInt(CLICKS_EXTRA, 0)
      Log.i(TAG, "Initial counter value assigned")

      incrementedValueTxt.text = "$clicks"

      incrementBtn.setOnClickListener {
         incrementedValueTxt.text = (++clicks).toString()  //klikšķa listenera darbība

         getPreferences(Application.MODE_PRIVATE)
            .edit()
            .putInt(CLICKS_EXTRA, clicks)
            .apply()
      }
   }
   override fun onSaveInstanceState(outState: Bundle) {
      super.onSaveInstanceState(outState)
      outState.putInt(CLICKS_EXTRA, clicks)
   }

   fun onClickIncrementBtn(view: View) {}

}