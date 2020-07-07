package com.example.smalltiktok

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smalltiktok.recycler.MsgData
import com.example.smalltiktok.recycler.MsgDataSet
import com.example.smalltiktok.recycler.MsgAdapter

class MainActivity : AppCompatActivity(),MsgAdapter.IOnItemClickListener{
    private val TAG = "MainActivityLog"
    private var msgRecycler: RecyclerView? = null
    private var msgAdapter: MsgAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private fun initView() {
        val appInfo = applicationInfo

        msgRecycler = findViewById(R.id.msgRecycler)
        msgAdapter = MsgAdapter(MsgDataSet.getData(resources.getIdentifier("circle","mipmap",appInfo.packageName)))
        layoutManager = LinearLayoutManager(this)

        msgRecycler!!.setHasFixedSize(true)
        msgRecycler!!.layoutManager = layoutManager
        Log.i(TAG,"set Listener")
        msgAdapter!!.setOnItemClickListener(this)

        Log.i(TAG,"set Adapter")
        msgRecycler!!.adapter = msgAdapter

        Log.i(TAG,"add Item Decoration")
        msgRecycler!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

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
        Log.i(TAG,"Click $position item")
        val intent = Intent(this, MsgActivity::class.java)
        Log.i(TAG,"put key-value (\"itemNumber\",$position) in intent")
        intent.putExtra("itemNumber",position)
        startActivity(intent)
    }

    override fun onItemLongCLick(position: Int, data: MsgData?) {
        //Toast.makeText(this@MainActivity, "长按了第" + position + "条", Toast.LENGTH_SHORT).show()
        //msgAdapter.removeData(position)
    }
}