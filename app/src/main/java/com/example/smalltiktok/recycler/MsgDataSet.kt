package com.example.smalltiktok.recycler

object MsgDataSet {
    public fun getData(ID: Int): List<MsgData> {
        return listOf(
            MsgData("游戏小助手", "新游戏上线了！大家都在等你来！", "刚刚", ID),
            MsgData("抖音小助手", "您的视频刚刚通过审核了！快跟...", "22:31", ID),
            MsgData("系统消息", "您的账号有异常登录情况！", "19:23", ID),
            MsgData("肉肉丸", "感谢您的关注！", "14:40", ID),
            MsgData("Sky_miner", "感谢您的关注！", "14:38", ID),
            MsgData("法式蝴蝶薯条", "这个Sky_miner视频超好看的", "12:30", ID),
            MsgData("林木", "快去关注Sky!", "昨天", ID),
            MsgData("大家都说名字越长越好但是我不这么认...", "[Hi]", "7-5", ID),
            MsgData("Customer", "您好", "7-5", ID),
            MsgData("来自附近的人", "让我康康", "7-4", ID),
            MsgData("233", "666", "6-30", ID)
        )
    }
}