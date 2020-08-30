package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class ShoppingItem(
    val name: String,
    val quantity: Int,
    val unit: String
)
class GridExampleActivity : AppCompatActivity() {
    private val shoppingItems = mutableListOf(
        ShoppingItem("Milk", 1, "l"),
        ShoppingItem("Bread", 1, "pcs."),
        ShoppingItem("Potatoes", 2, "kg"),
        ShoppingItem("Eggs", 10, "pcs.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_example)
    }

}