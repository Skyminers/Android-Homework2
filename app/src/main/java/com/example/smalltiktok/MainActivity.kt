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
    private val TAG = "MainActivityLogTag"
    private var msgRecycler: RecyclerView? = null
    private var mAdapter: MyAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private fun initView() {
        val appInfo = applicationInfo

        msgRecycler = findViewById(R.id.msgRecycler)
        mAdapter = MyAdapter(MsgDataSet.getData(resources.getIdentifier("circle","mipmap",appInfo.packageName)))
        layoutManager = LinearLayoutManager(this)

        msgRecycler!!.setHasFixedSize(true)
        msgRecycler!!.layoutManager = layoutManager
        Log.i(TAG,"set Listener")
        mAdapter!!.setOnItemClickListener(this)

        Log.i(TAG,"set Adapter")
        msgRecycler!!.adapter = mAdapter

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

        //Toast.makeText(this@MainActivity, "点击了第" + position + "条", Toast.LENGTH_SHORT).show()
        //mAdapter.addData(position + 1, MsgData("新增头条", "0w"))
    }

    override fun onItemLongCLick(position: Int, data: MsgData?) {
        //Toast.makeText(this@MainActivity, "长按了第" + position + "条", Toast.LENGTH_SHORT).show()
        //mAdapter.removeData(position)
    }
}