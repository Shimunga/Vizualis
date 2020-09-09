package com.example.vizualis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_shopping.view.*
import kotlinx.android.synthetic.main.item_shopping_card.view.*
import lv.romstr.mobile.rtu_android.*
import kotlinx.android.synthetic.main.item_shopping_card.view.removeBtn as removeBtn1

class DatabaseSampleAdapter(
   private val listener: AdapterEventListener,
   private val items: MutableList<ShoppingItemForDb>) :
   RecyclerView.Adapter<DatabaseSampleAdapter.ShoppingViewHolder>() {

   class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view)

   //Inflate layout and create view holder
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
      val view =
         LayoutInflater.from(parent.context).inflate(R.layout.item_shopping_card, parent, false)
      return ShoppingViewHolder(view)
   }

   // Need to return item count
   override fun getItemCount() = items.size

   override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
      val item = items[position]
      val context = holder.itemView.context
      holder.itemView.titleTxt.text = item.title
      holder.itemView.descriptionTxt.text = item.text

      holder.itemView.setOnClickListener {
         Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
      }

      holder.itemView.removeBtn1.setOnClickListener{
         val currPos = items.indexOf(item)
         listener.deleteClicked(items[currPos])
         items.removeAt(currPos)
         notifyDataSetChanged()
      }
   }
}