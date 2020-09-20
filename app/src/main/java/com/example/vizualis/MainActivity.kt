package com.example.vizualis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import android.widget.Button
//import android.widget.TextView
import android.widget.Toast
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import com.example.vizualis.chat.ChatFirstActivity
import com.example.vizualis.clicker_mvvm.ClickerActivity
import com.example.vizualis.fragment.SimpleFragmentActivity
import com.example.vizualis.recycleviewscollview.RecycleViewActivity
import com.example.vizualis.recycleviewscollview.ScrollViewActivity
import com.example.vizualis.shopping.DatabaseSampleActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incrementBtn.setOnClickListener {
            val clickerAct = Intent(this, com.example.vizualis.clicker.ClickerActivity::class.java)
            startActivity(clickerAct)
        }

        twoBtn.setOnClickListener {
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_LONG).show() //tosterītis izlec
            Log.i(TAG, "Toast is ready!")
        }

        openChatBtn.setOnClickListener {
            onClickOpenChatBtn(it)
        }

        fourBtn.setOnClickListener {
            val listPage = Intent(this, ListExampleActivity::class.java)
            startActivity(listPage)
            Log.i(TAG, "List act. opened")
        }
    }

    private fun onClickOpenChatBtn(v: View) {
        val intent = Intent(this, ChatFirstActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "Open Chat acitvity openened")
    }

    fun onClickScrollViewBtn(v: View) {
        val intent = Intent(this, ScrollViewActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "ScrollView Activity opened")
    }

    fun onClickGridViewBtn(v: View) {
        val intent = Intent(this, GridExampleActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "GridView Activity opened")
    }

    fun onClickRecyclerBtn(v: View) {
        val intent = Intent(this, RecycleViewActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "Recycler Activity opened")
    }

    fun onClickIncludeBtn(v: View) {
        val intent = Intent(this, IncludeActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "Include")
    }
    fun onClickStylesBtn(v: View) {
        val intent = Intent(this, StylesThemesActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "Styles Themes")
    }

    fun onClickDatabaseSampleBtn(v: View) {
        val intent = Intent(this, DatabaseSampleActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "DatabaseSampleActivity button clicked")
    }

    fun onClickAlertsTabsPagesBtn(view: View) {
        val intent = Intent(this, AlertsTabsPagesActivity::class.java)
        startActivity(intent)
    }

    fun onClickOpenFragActivBtn(view: View) {
        val intent = Intent(this, SimpleFragmentActivity::class.java)
        startActivity(intent)
    }

    fun onClickClickerMvvm(view: View) {
        val intent = Intent(this, com.example.vizualis.clicker_mvvm.ClickerActivity::class.java)
            .putExtra(ClickerActivity.CLICKS_EXTRA, 25)
        startActivity(intent)
    }

}