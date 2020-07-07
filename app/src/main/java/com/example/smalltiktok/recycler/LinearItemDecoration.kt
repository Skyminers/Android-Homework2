package com.example.smalltiktok.recycler

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class LinearItemDecoration(color: Int) : ItemDecoration() {

    private val mPaint: Paint = Paint()

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val childCount = parent.childCount
        // 获取需要绘制的区域
        val rect = Rect()
        rect.left = parent.paddingLeft
        rect.right = parent.width - parent.paddingRight
        for (i in 0 until childCount) {
            val childView = parent.getChildAt(i)
            rect.top = childView.bottom
            rect.bottom = rect.top + 1
            // 直接利用Canvas去绘制一个矩形 在留出来的地方
            c.drawRect(rect, mPaint)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom += 1
    }

    init {
        mPaint.color = color
        mPaint.isAntiAlias = true
    }
}
