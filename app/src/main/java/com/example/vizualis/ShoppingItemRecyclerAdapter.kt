package com.example.vizualis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shopping_card.view.*

class ShoppingItemRecyclerAdapter(private val items: List<RecycleViewActivity.ShoppingItemCard>) :
   RecyclerView.Adapter<ShoppingItemRecyclerAdapter. ShoppingViewHolder>() {

   //Define view holder class
   class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view)

   //Inflate layout and create view holder
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
      val view =
         LayoutInflater.from(parent.context).inflate(R.layout.item_shopping_card, parent, false)
      return ShoppingViewHolder(view)
   }
   // Need to return item count
   override fun getItemCount() = items.size

   // Bind item to view holder
   override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
      val item = items[position]
      val context = holder.itemView.context
      holder.itemView.titleTxt.text = item.title
      holder.itemView.descriptionTxt.text = item.description

      holder.itemView.setOnClickListener {
         Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
      }
   }
}