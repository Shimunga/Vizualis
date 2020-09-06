package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_recycle_view.*
import java.util.*

class RecycleViewActivity : AppCompatActivity() {
   companion object {
      const val TAG = "RecycleViewActivity"
   }

   data class ShoppingItemCard(
      val title: String,
      val description: String
   )

   private val shoppingItems = mutableListOf(
      ShoppingItemCard("Milk", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer"),
      ShoppingItemCard("Bread", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its ")
   )

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_recycle_view)
      //setup adapter
      val adapter = ShoppingItemRecyclerAdapter(shoppingItems)
      mainItemsGrd.adapter = adapter
   }

   fun onClickAddBtn(v: View) {
      val name = itemEd.text.toString()
      Log.d(TAG, "Add item " + name)
      shoppingItems.add(0, ShoppingItemCard(name, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical "))
      mainItemsGrd.adapter?.notifyDataSetChanged()
      itemEd.setText("some text " + (1000..9999).random().toString())
   }

   fun onClickSortBtn(view: View) {
      //shoppingItems.sortedBy{view.transitionName}
   }

}