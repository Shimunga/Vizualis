package com.example.vizualis.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vizualis.R
import kotlinx.android.synthetic.main.fragment_simple.view.*
import kotlinx.android.synthetic.main.fragment_simple.view.textView

class SimpleFragment : Fragment() {

   private var listener: ButtonPressedListener? = null

   override fun onAttach(context: Context) {
      super.onAttach(context)
      listener = context as ButtonPressedListener
   }

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_simple, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      view.fragmentBtn.setOnClickListener {
         listener?.onButtonPressed("Pressed from fragment!")

         val message = arguments!!.getString(EXTRA_MESSAGE)
         view.textView.text = message
         //Toast.makeText(context, message, Toast.LENGTH_LONG).show()
      }
   }

      companion object {
      fun newInstance(message: String): SimpleFragment {
         val fragment = SimpleFragment()
         val args = Bundle()
         args.putString(EXTRA_MESSAGE, message)
         fragment.arguments = args
         return fragment
      }
      const val EXTRA_MESSAGE = "FRAG_MESSAGE"
   }
}
interface ButtonPressedListener {
   fun onButtonPressed(message: String)
}



