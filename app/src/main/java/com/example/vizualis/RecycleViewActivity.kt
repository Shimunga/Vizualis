package com.example.vizualis

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view.*
import java.lang.Override as Override1


class RecycleViewActivity : AppCompatActivity() {
   companion object {
      const val TAG = "RecycleViewActivity"
   }

   data class ShoppingItemCard(
      val title: String,
      val description: String
   )

   private val shoppingItems = mutableListOf(
      ShoppingItemCard("Milk", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer"),
      ShoppingItemCard("Bread", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its "),
      ShoppingItemCard("Water", "Ut aliquam purus sit amet luctus venenatis lectus magna. Tincidunt lobortis feugiat vivamus at augue eget arcu. Aliquam etiam erat velit scelerisque. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Eget dolor morbi non arcu risus quis varius quam quisque. Habitasse platea dictumst vestibulum rhoncus est. Morbi tincidunt ornare massa eget egestas purus viverra. Pellentesque id nibh tortor id aliquet. Aliquam vestibulum morbi blandit cursus risus at ultrices mi tempus. Pellentesque adipiscing commodo elit at. Sed enim ut sem viverra aliquet. Ac feugiat sed lectus vestibulum. Ac turpis egestas maecenas pharetra. Posuere ac ut consequat semper viverra. ")
   )

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_recycle_view)
      //setup adapter
      val adapter = ShoppingItemRecyclerAdapter(shoppingItems)
      mainItemsGrd.adapter = adapter

      staggLinearSwitch.setOnCheckedChangeListener { _, isChecked -> switchLayouts(isChecked) }

   }

   fun onClickAddBtn(v: View) {
      val name = itemEd.text.toString()
      Log.d(TAG, "Add item " + name)
      shoppingItems.add(0, ShoppingItemCard(name, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical "))
      //repaints all elements
      //mainItemsGrd.adapter?.notifyDataSetChanged()
      //repaints only inserted at the position specified
      mainItemsGrd.adapter?.notifyItemInserted(0) //0 - cause inserted at frst postition (see above)
      mainItemsGrd.smoothScrollToPosition(0) //as only first was repainted, view is still on previous position. This will scroll to first - newly inserted
      itemEd.setText("some text " + (1000..9999).random().toString())
   }

   fun onClickSortBtn(view: View) {
      //shoppingItems.sortedBy{view.transitionName}
   }

   fun switchLayouts(/*buttonView: CompoundButton, */isChecked: Boolean) {
      Log.v("Switch State=", "" + isChecked)

      if (isChecked) {
         mainItemsGrd.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      }else {
         mainItemsGrd.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
         (mainItemsGrd.layoutManager as StaggeredGridLayoutManager).setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
      }
   }
}
