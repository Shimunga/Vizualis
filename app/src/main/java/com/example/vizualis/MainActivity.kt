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

class MainActivity : AppCompatActivity() {
    private var clicks = 0
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "Created")

        nosaukTxt.text = (++clicks).toString() //sākotnējā inkrementētā vērtība
        Log.i(TAG, "Initial counter value assigned")
        //findViewById<TextView>(R.id.nosaukTxt).text = (++clicks).toString() //sākotnējā inkrementētā vērtība

        oneBtn.setOnClickListener {
            nosaukTxt.text = (++clicks).toString()  //klikšķa listenera darbība
            Log.i(TAG, "Counter increment clicked")
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

    fun onClickOpenChatBtn(v: View) {
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

}