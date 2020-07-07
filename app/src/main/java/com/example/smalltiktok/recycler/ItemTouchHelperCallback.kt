package com.example.smalltiktok.recycler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.smalltiktok.R

class ItemTouchHelperCallback(val itemTouchAdapter: ItemTouchAdapter,val mContext: Context) : ItemTouchHelper.Callback(){

    // 设定滑动方向的权限
    override fun getMovementFlags(p0: RecyclerView, p1: RecyclerView.ViewHolder): Int {
        return makeMovementFlags(0,ItemTouchHelper.LEFT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    // 当Item收到拖动时，会调用函数
    // dX,dY 标定位移
    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            drawBackground(c,viewHolder.itemView, Color.parseColor("silver"),dX.toInt())
            if(dX < -240){
                //drawBackground(c,viewHolder.itemView, Color.parseColor("silver"),dX.toInt())
                drawDeleteIcon(c,viewHolder.itemView)
            }
        }
    }

    val background = ColorDrawable()

    // 绘制红色背景
    fun drawBackground(c : Canvas, itemView : View, @ColorInt color: Int, dX: Int){
        background.color = color
        // 规定绘制边界
        background.setBounds(itemView.right+dX,itemView.top+10,itemView.right,itemView.bottom)
        background.draw(c)
    }
    // 绘制删除图标
    fun drawDeleteIcon(c : Canvas, itemView : View){
        val deleteIcon = ContextCompat.getDrawable(mContext, R.drawable.ic_delete_24dp) ?: return
        val itemHeight = itemView.height
        val iconHeight = deleteIcon.intrinsicHeight
        val iconWidth = deleteIcon.intrinsicWidth
        val deleteMargin = (itemHeight - iconHeight) / 2
        // 规定绘制边界
        deleteIcon.setBounds(itemView.right - iconWidth - deleteMargin,
            itemView.top + deleteMargin,
            itemView.right - deleteMargin,
            itemView.bottom - deleteMargin)
        deleteIcon.draw(c)
    }
    // 上下拖拽时该函数会被调用: 表示p1被移动，移动结束的位置距离p2最近
    /*
    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        itemTouchAdapter.onItemMove(p1.adapterPosition,p2.adapterPosition)
        return true
    }*/
    // 左右滑动删除Item时该函数会被调用，p1表示滑动的方向(4 -> 左,8 -> 右)
    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        if(p1 == 4) itemTouchAdapter.onItemDismiss(p0.adapterPosition)
    }

}