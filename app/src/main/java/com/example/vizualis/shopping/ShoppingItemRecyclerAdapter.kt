package com.example.vizualis.shopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vizualis.R
import com.example.vizualis.keepitem.*
import kotlinx.android.synthetic.main.item_shopping_card.view.*
import kotlinx.android.synthetic.main.item_shopping_card_img.view.*
import kotlinx.android.synthetic.main.item_shopping_card.view.removeBtn as removeBtn1

class ShoppingItemRecyclerAdapter(private val items: MutableList<KeepItem>) :
   RecyclerView.Adapter<ShoppingItemRecyclerAdapter.KeepViewHolder>() {

   companion object {
      private const val TEXT_KEEP = 0
      private const val IMAGE_KEEP = 1
   }

//Need to understnd item type
   override fun getItemViewType(position: Int) =
      if (items[position] is KeepItemText) TEXT_KEEP else IMAGE_KEEP

// Need to return item count
   override fun getItemCount() = items.size

//Define view holder class
   abstract class KeepViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      abstract fun bind(position: Int)
   }
   inner class TextViewHolder(view: View) : KeepViewHolder(view) {
      override fun bind(position: Int) {
         val item = items[position] as KeepItemText
         itemView.titleTxt.text = item.title
         itemView.descriptionTxt.text = item.text
      }
   }
   inner class ImageViewHolder(view: View) : KeepViewHolder(view) {
      override fun bind(position: Int) {
         val item = items[position] as KeepItemImage
         itemView.imageTitleTxt.text = item.title
         Glide.with(itemView)
            .load(item.uri)
            .into(itemView.bildeImg)
      }
   }
//-----------------------------------------------------

   //Inflate layout and create view holder
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeepViewHolder {
      val inflater = LayoutInflater.from(parent.context)
      return if (viewType == IMAGE_KEEP) {
         ImageViewHolder(inflater.inflate(R.layout.item_shopping_card_img, parent, false))
      }else{
         TextViewHolder(inflater.inflate(R.layout.item_shopping_card, parent, false))
      }
   }

   // Bind item to view holder
   override fun onBindViewHolder(holder: KeepViewHolder, position: Int) {
      holder.bind(position)
      val item = items[position]
      val context = holder.itemView.context


      holder.itemView.setOnClickListener {
         //val title: String
         //title = if (item is KeepItemText) (item as KeepItemText).title else (item as KeepItemText).title
         Toast.makeText(context, item.title, Toast .LENGTH_SHORT).show()
      }

      holder.itemView.removeBtn1.setOnClickListener{
         val currPos = items.indexOf(item)
         items.removeAt(currPos)
         notifyDataSetChanged()
      }

   }
}