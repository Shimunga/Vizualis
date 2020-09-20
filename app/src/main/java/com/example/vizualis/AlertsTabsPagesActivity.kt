package com.example.vizualis

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.vizualis.fragment.DatePickerFragment
import com.example.vizualis.fragment.ProductDialogFragment

class AlertsTabsPagesActivity : AppCompatActivity()/*, ProductDialogFragment.NoticeDialogListener */{

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
               "Simple dialog Ok clicked",
               Toast.LENGTH_SHORT
            ).show()
         }
         .setNegativeButton("cancel"){ dialog, id -> onNegativeClick(dialog, id)}
         .setNeutralButton("remind me later") { _, _ -> }
      val dialog = builder.create()
      dialog.show()
   }

   fun onNegativeClick(dialog: DialogInterface, which: Int){
      Toast.makeText(
         this,
         "Simple dialog Nok clicked",
         Toast.LENGTH_SHORT
      ).show()
   }

   fun onClickListDialogBtn(view: View) {
      val builder = AlertDialog.Builder(this)
      val products = arrayOf("Bread", "Eggs", "Milk", "Potatoes")
      builder.setTitle("Choose product")
         .setItems(products) { dialog, which ->
            Toast.makeText(
               this,
               "List dialog clicked: ${products[which]}",
               Toast.LENGTH_SHORT
            ).show()
         }
      val dialog = builder.create()
      dialog.show()
   }

   fun onClickMultiChoiceDialogBtn(view: View) {
      val builder = AlertDialog.Builder(this)
      val products = arrayOf("Bread", "Eggs", "Milk", "Potatoes")
      val checked = booleanArrayOf(true, true, false, true)
      val selectedItems = mutableListOf<Int>()
      builder
         .setTitle("Choose product")
         .setMultiChoiceItems(products,checked) { dialog, which, isChecked ->
            if (isChecked) selectedItems.add(which) else selectedItems.remove(which)
         }
         .setPositiveButton("ok") { dialog, id ->
            Toast.makeText(
               this,
               selectedItems.toString(),
               Toast.LENGTH_SHORT
            ).show()
         }
      val dialog = builder.create()
      dialog.show()
   }

   fun onClickCustomDialogBtn(view: View) {
      val builder = AlertDialog.Builder(this)
      builder
         .setTitle("Title")
         .setView(R.layout.dialog_custom)
         .setPositiveButton("ok") { dialog, id ->
            Toast.makeText(
               this,
               "Custom dialog Ok clicked",
               Toast.LENGTH_SHORT
            ).show()
         }
         .setNegativeButton("cancel"){ _, _ ->}
      val dialog = builder.create()
      dialog.show()
   }

   fun onClickFragmentDialogBtn(view: View) {
      val dialogFragment = ProductDialogFragment()
      dialogFragment.show(this.supportFragmentManager, null)
   }

/*   override fun onDialogPositiveClick(dialog: DialogFragment) {
      Toast.makeText(
         this,
         "Ok from fragment dialog handler",
         Toast.LENGTH_SHORT
      ).show()
   }

   override fun onDialogNegativeClick(dialog: DialogFragment) {
      TODO("Not yet implemented")
   }*/

   fun onClickDatePickerDialogBtn(view: View) {
      val datePickerFragment = DatePickerFragment()
      datePickerFragment.show(supportFragmentManager,"datePicker")
   }

}