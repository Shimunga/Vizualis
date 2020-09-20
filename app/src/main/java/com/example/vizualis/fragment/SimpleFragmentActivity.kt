package com.example.vizualis.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vizualis.R

class SimpleFragmentActivity : AppCompatActivity(),
   ButtonPressedListener {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      //set fragment statically
      setContentView(R.layout.activity_simple_fragment)

      //set fragment programmatically
      val fragmentTransaction = supportFragmentManager.beginTransaction()
      //val fragment = SimpleFragment()
      val fragment = SimpleFragment.newInstance("This message was passed from activity")
      fragmentTransaction.add(R.id.fragmentContainer, fragment)
      fragmentTransaction.commit()
   }

   override fun onButtonPressed(message: String) {
      Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
   }
}