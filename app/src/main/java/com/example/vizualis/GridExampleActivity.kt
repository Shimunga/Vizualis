package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.vizualis.shopping.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_grid_example.*


data class ShoppingItem(
    val name: String,
    val quantity: Int,
    val unit: String
)
class GridExampleActivity : AppCompatActivity() {
    companion object {
        const val TAG = "GridExampleActivity"
    }
    private val shoppingItems = mutableListOf(
        ShoppingItem("Milk", 1, "l"),
        ShoppingItem("Bread", 1, "pcs."),
        ShoppingItem("Potatoes", 2, "kg"),
        ShoppingItem("Eggs1", 11, "pcs."),
        ShoppingItem("Eggs2", 12, "pcs."),
        ShoppingItem("Eggs3", 13, "pcs."),
        ShoppingItem("Eggs4", 14, "pcs."),
        ShoppingItem("Eggs5", 15, "pcs."),
        ShoppingItem("Eggs6", 16, "pcs."),
        ShoppingItem("Eggs7", 17, "pcs."),
        ShoppingItem("Eggs8", 18, "pcs."),
        ShoppingItem("Eggs9", 19, "pcs."),
        ShoppingItem("Eggs10", 20, "pcs.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_example)

        //setup adapter
        val adapter =
           ShoppingItemAdapter(this, shoppingItems)
        mainItemsGrd.adapter = adapter

        mainItemsGrd.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, shoppingItems[position].name, Toast.LENGTH_SHORT).show()
        }
    }
    fun onClickAddBtn(v: View) {
        val name = itemEd.text.toString()
        Log.d(TAG, "Add item " + name)
        shoppingItems.add(ShoppingItem(name, 1, "l"))
        (mainItemsGrd.adapter as BaseAdapter).notifyDataSetChanged()
    }

//    fun onClickDeleteBtn(v: View) {
//        val name = itemEd.text.toString()
//        Log.d(TAG, "Add item " + name)
//        shoppingItems.add(ShoppingItem(name, 1, "l"))
//        (mainItemsGrd.adapter as BaseAdapter).notifyDataSetChanged()
//    }
}