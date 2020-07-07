package com.example.smalltiktok.recycler


// 定义TouchAdapter接口
interface ItemTouchAdapter{
    //fun onItemMove(fromPos: Int,toPos: Int): Boolean
    fun onItemDismiss(position: Int)
}