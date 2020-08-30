//Array adapter
package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_example.*

class ListExampleActivity : AppCompatActivity() {
    private val items = mutableListOf("Cupcake", "Donut", "Eclair", "Froyo"
        , "Gingerbread", "Honeycomb", "Ice Cream Sandwich","Jelly Bean", "KitKat", "Lollipop"
        , "Marshmallow", "Nougat", "Oreo", "Pie", "10", "11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_example)

        val adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, items)
        mainItemsGrd.adapter = adapter

        mainItemsGrd.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, items[position], Toast.LENGTH_SHORT).show()
        }

    }

}