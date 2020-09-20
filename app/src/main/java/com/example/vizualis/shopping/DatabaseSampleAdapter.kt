package com.example.vizualis.shopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.vizualis.R
import kotlinx.android.synthetic.main.item_shopping_card.view.*
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
      return ShoppingViewHolder(
         view
      )
   }

   // Need to return item count
   override fun getItemCount() = items.size

   var context: Context? = null
   var item: ShoppingItemForDb? = null

   override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
      item = items[position]
      context = holder.itemView.context
      holder.itemView.titleTxt.text = item?.title
      holder.itemView.descriptionTxt.text = item?.text

      holder.itemView.setOnClickListener {
         Toast.makeText(context, item?.title, Toast.LENGTH_SHORT).show()
      }


      holder.itemView.removeBtn1.setOnClickListener{
         //deleteItem(items.indexOf(item))
         WannaDelete()
      }
   }

   private fun WannaDelete(){
      val builder = AlertDialog.Builder(context!!)
      builder.setTitle("Title")
         .setMessage("Lorem ipsum blablabla")
         .setPositiveButton("ok") { dialog, id ->
            deleteItem(items.indexOf(item))
         }
         .setNegativeButton("cancel") { _, _ -> }
         .setNeutralButton("remind me later") { _, _ -> }
      val dialog = builder.create()
      dialog.show()
   }

   private fun deleteItem (position: Int) {
      listener.deleteClicked(items[position])
      items.removeAt(position)
      notifyDataSetChanged()
   }

}