package com.example.smalltiktok

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smalltiktok.recycler.MsgData
import com.example.smalltiktok.recycler.MsgDataSet
import com.example.smalltiktok.recycler.MyAdapter

class MainActivity : AppCompatActivity(),MyAdapter.IOnItemClickListener{
    private val TAG = "MainActivity"

    private var msgRecycler: RecyclerView = findViewById(R.id.msgRecycler)
    private var mAdapter: MyAdapter = MyAdapter(MsgDataSet.getData())
    private var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

    private fun initView() {

        msgRecycler.setHasFixedSize(true)
        msgRecycler.layoutManager = layoutManager

        mAdapter.setOnItemClickListener(this)
        msgRecycler.adapter = mAdapter
        msgRecycler.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG,"RecyclerViewActivity onCreate")
        initView()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "RecyclerViewActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"RecyclerViewActivity onResume")
    }


    override fun onItemCLick(position: Int, data: MsgData?) {
        Toast.makeText(this@MainActivity, "点击了第" + position + "条", Toast.LENGTH_SHORT)
            .show()
        //mAdapter.addData(position + 1, MsgData("新增头条", "0w"))
    }

    override fun onItemLongCLick(position: Int, data: MsgData?) {
        Toast.makeText(this@MainActivity, "长按了第" + position + "条", Toast.LENGTH_SHORT)
            .show()
        //mAdapter.removeData(position)
    }
}