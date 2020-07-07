package com.example.smalltiktok.recycler

object IconsDataSet {
    public fun getData(ID: Int): List<IconsData> {
        return listOf(
            IconsData("粉丝",ID),
            IconsData("赞",ID),
            IconsData("@我的",ID),
            IconsData("评论",ID),
            IconsData("留言板",ID),
            IconsData("举报记录",ID)
        )
    }
}