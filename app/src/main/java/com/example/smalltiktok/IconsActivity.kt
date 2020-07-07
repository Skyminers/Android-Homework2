package com.example.smalltiktok

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class IconsActivity : Activity() {

    private val TAG = "IconsActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icons_details)
        Log.i(TAG,"Start a new Activity")
        val intent = intent
        val text = "Icons Item Name : ${intent.getStringExtra("itemNumber-Icons")}"
        val textView = findViewById<TextView>(R.id.textView)
        Log.i(TAG,"get $text")
        textView.text = text
    }
}