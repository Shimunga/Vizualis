package com.example.vizualis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var clicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.nosaukTxt).text = (++clicks).toString() //sākotnējā inkrementētā vērtība

        findViewById<Button>(R.id.oneBtn).setOnClickListener {
            findViewById<TextView>(R.id.nosaukTxt).text = (++clicks).toString()  //klikšķa listenera darbība
        }
    }
}