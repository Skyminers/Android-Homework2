package com.example.smalltiktok

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.example.smalltiktok.recycler.*

class MainActivity : AppCompatActivity(),MsgAdapter.IOnItemClickListener, IconsAdapter.IOnItemClickListener{
    private val TAG = "MainActivityLog"
    private var msgRecycler: RecyclerView? = null
    private var msgAdapter: MsgAdapter? = null
    private var msglayoutManager: RecyclerView.LayoutManager? = null

    private var iconsRecycler: RecyclerView? = null
    private var iconsAdapter: IconsAdapter? = null
    private var iconslayoutManager: RecyclerView.LayoutManager? = null

    private fun initView() {
        val appInfo = applicationInfo

        msgRecycler = findViewById(R.id.msgRecycler)
        msgAdapter = MsgAdapter(MsgDataSet.getData(resources.getIdentifier("circle","mipmap",appInfo.packageName)))
        msglayoutManager = LinearLayoutManager(this)

        iconsRecycler = findViewById(R.id.iconsRecycler)
        iconsAdapter = IconsAdapter(IconsDataSet.getData(resources.getIdentifier("circle","mipmap",appInfo.packageName)))
        iconslayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        msgRecycler!!.setHasFixedSize(true)
        msgRecycler!!.layoutManager = msglayoutManager

        iconsRecycler!!.setHasFixedSize(true)
        iconsRecycler!!.layoutManager = iconslayoutManager

        Log.i(TAG,"set Listener")
        msgAdapter!!.setOnItemClickListener(this)
        iconsAdapter!!.setOnItemClickListener(this)

        Log.i(TAG,"set Adapter")
        msgRecycler!!.adapter = msgAdapter
        iconsRecycler!!.adapter = iconsAdapter

        Log.i(TAG,"add Item Decoration")
        msgRecycler!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        iconsRecycler!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL))
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
        Log.i(TAG,"Click Msg $position item")
        val intent = Intent(this, MsgActivity::class.java)
        Log.i(TAG,"put key-value (\"itemNumber-Msg\",$position) in intent")
        intent.putExtra("itemNumber-Msg",position)
        startActivity(intent)
    }

    override fun onItemCLick(position: Int, data: IconsData?) {
        Log.i(TAG,"Click Icons $position item")
        val intent = Intent(this, IconsActivity::class.java)
        Log.i(TAG,"put key-value (\"itemNumber-Icons\",$position) in intent")
        intent.putExtra("itemNumber-Icons",position)
        startActivity(intent)
    }

    override fun onItemLongCLick(position: Int, data: IconsData?) {

    }

    override fun onItemLongCLick(position: Int, data: MsgData?) {
        //Toast.makeText(this@MainActivity, "长按了第" + position + "条", Toast.LENGTH_SHORT).show()
        //msgAdapter.removeData(position)
    }
}