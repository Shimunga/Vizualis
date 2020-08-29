package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_example.*

class ListExampleActivity : AppCompatActivity() {
    private val items = mutableListOf("Cupcake", "Donut", "Eclair", "Froyo"
        , "Gingerbread", "Honeycomb", "Ice Cream Sandwich","Jelly Bean", "KitKat", "Lollipop"
        , "Marshmallow", "Nougat", "Oreo", "Pie", "10", "11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_example)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        mainItems.adapter = adapter
    }
}