package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertsTabsPagesActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {

      super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_alerts_tabs_pages)
   }

   fun onClickShowDialogBtn(view: View) {
      val builder = AlertDialog.Builder(this)
      builder.setTitle("Title")
         .setMessage("Lorem ipsum blablabla")
         .setPositiveButton("ok") { dialog, id ->
            Toast.makeText(
               this,
               "Ok clicked",
               Toast.LENGTH_SHORT
            ).show()
         }
         .setNegativeButton("cancel") { _, _ -> }
         .setNeutralButton("remind me later") { _, _ -> }
      val dialog = builder.create()
      dialog.show()
   }
}