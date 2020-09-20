package com.example.vizualis.chat

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.vizualis.R
import com.example.vizualis.chat.ChatFirstActivity.Companion.EXTRA_MESSAGE
import com.example.vizualis.chat.ChatFirstActivity.Companion.EXTRA_REPLY
import kotlinx.android.synthetic.main.activity_chat_first.*
import kotlinx.android.synthetic.main.activity_chat_first.messageEd

class ChatSecondActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ChatSecondActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_second)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        messageTxt.append(message)
    }
    fun onClickReplayBtn(v: View) {
        val message = messageEd.text.toString();
        val result = Intent().apply {
            putExtra(EXTRA_REPLY, message)
        }
        setResult(Activity.RESULT_OK, result)
        Log.d(TAG, "to finish ChatSecondActivity")

        finish()
    }

}