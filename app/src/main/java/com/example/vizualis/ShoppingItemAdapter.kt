package com.example.vizualis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingItemAdapter(context: Context, items: List<ShoppingItem>) :
    ArrayAdapter<ShoppingItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_shopping, parent, false)

        val item = getItem(position)

        view.shoppingName.text = item?.name
        view.shoppingQuantity.text = context.resources
            .getString(R.string.quantity_text, item?.quantity, item?.unit)

        view.setOnClickListener {
            Toast.makeText(context, item?.name, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}