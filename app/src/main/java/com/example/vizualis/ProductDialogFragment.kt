package com.example.vizualis

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import java.util.*

class ProductDialogFragment : DialogFragment() {

//   var action: (() -> Unit)? = null
//   private lateinit var listener: NoticeDialogListener
   private lateinit var alertDialog: AlertDialog

   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
      val builder = AlertDialog.Builder(requireContext())
      builder.setTitle("Title")
         .setMessage("This is message")
         .setPositiveButton("ok") { dialog, id -> Toast.makeText(
            requireContext(),
            "Ok from fragment dialog",
            Toast.LENGTH_SHORT
         ).show()
         }
         .setNegativeButton("cancel") { _, _ -> }
      val dialog = builder.create()
      return dialog
   }

   override fun onStop() {
      //alertDialog.dismiss() //diez kāpēc izsauc aciivity aizvēršanos un app krešu
      super.onStop()
   }

//   override fun onAttach(context: Context) {
//      super.onAttach(context)
//      listener = context as NoticeDialogListener
//   }
//
//   interface NoticeDialogListener {
//      fun onDialogPositiveClick(dialog: DialogFragment)
//      fun onDialogNegativeClick(dialog: DialogFragment)
//   }
}

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

      override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         // Use the current date as the default date in the picker
         val c = Calendar.getInstance()
         val year = c.get(Calendar.YEAR)
         val month = c.get(Calendar.MONTH)
         val day = c.get(Calendar.DAY_OF_MONTH)
          // Create a new instance of DatePickerDialog and return it
         return DatePickerDialog(requireActivity(), this, year, month, day)
      }

      override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
         Toast.makeText(
            requireContext(),
            "$day.$month.$year",
            Toast.LENGTH_SHORT
         ).show()
      }
}