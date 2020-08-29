package com.example.vizualis

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_chat_first.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.messageEd

class ChatFirstActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "LEO_REPLAY"
        const val DETAIL_REQUEST = 123
        const val EXTRA_MESSAGE = "LEO_MESSAGE"
        const val TAG = "ChatFirstActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ChatFirstActivity created")
        setContentView(R.layout.activity_chat_first)
    }

    fun onClickSendBtn(v: View) {
        val message = messageEd.text.toString();
        val intent = Intent(this, ChatSecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
            }
        Log.d(TAG, "to start ChatSecondActivity")
        startActivityForResult(intent, DETAIL_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult")
        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.let {
                messageTxt.append(if (messageTxt.text == "") data.getStringExtra(EXTRA_REPLY) else System.lineSeparator() + data.getStringExtra(EXTRA_REPLY))
            }
        }
    }
}