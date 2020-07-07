package com.example.smalltiktok

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MsgActivity : Activity() {

    private val TAG = "MsgActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg_details)
        Log.i(TAG,"Start a new Activity")
        val intent = intent
        val text = "Msg Item Name : ${intent.getStringExtra("itemNumber-Msg")}"
        val textView = findViewById<TextView>(R.id.textView)
        Log.i(TAG,"get $text")
        textView.text = text
    }
}