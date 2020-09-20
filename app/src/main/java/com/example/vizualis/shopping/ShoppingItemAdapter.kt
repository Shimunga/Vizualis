package com.example.vizualis.shopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.vizualis.R
import com.example.vizualis.ShoppingItem
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingItemAdapter(context: Context, items: List<ShoppingItem>) :
    ArrayAdapter<ShoppingItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_shopping, parent, false)

        val item = getItem(position)!!

        view.imageTitleTxt.text = item.name
        view.shoppingQuantity.text = context.resources
            .getString(R.string.quantity_text, item.quantity, item.unit)

        view.setOnClickListener {
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}