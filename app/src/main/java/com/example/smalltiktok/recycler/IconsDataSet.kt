package com.example.smalltiktok.recycler

object IconsDataSet {
    public fun getData(ID: Int): List<IconsData> {
        return listOf(
            IconsData("粉丝",ID),
            IconsData("赞",ID),
            IconsData("@我的",ID),
            IconsData("评论",ID),
            IconsData("标题4",ID),
            IconsData("标题5",ID),
            IconsData("标题6",ID),
            IconsData("标题7",ID),
            IconsData("标题8",ID),
            IconsData("标题9",ID),
            IconsData("标题10",ID)
        )
    }
}