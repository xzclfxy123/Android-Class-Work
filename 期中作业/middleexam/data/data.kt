package com.example.compose.middleexam.data

import androidx.compose.ui.graphics.Color
import com.example.compose.middleexam.R.drawable.*

data class News(
    val id: Int,
    val name: String,
    val views: Int,
    val cover: Int,
    val details: String,
    val color: Color
)

data class Novel(
    val id: Int,
    val name: String,
    val amount: Int,
    val cover: Int,
    val details: String,
    val color: Color
)

object UserData {
    val new : MutableList<News> = mutableListOf(
        News(
            1,
            "「希望，是一只带有羽毛的东西。它在我的灵魂中筑巢栖息，唱着没有词的歌曲，似乎永远不会停息。」",
            999,
            inside,
            "「空气蛹 INSIDE」——《崩坏：星穹铁道》知更鸟首张专辑《空气蛹INSIDE》音乐活动H5现已正式上线QQ音乐、酷狗音乐，参与活动即可领取星琼。欢迎各位开拓者前往平台收听。",
            Color(0xFF39c5bb)
        ),
        News(
            2,
            "Bambino",
            999,
            kano,
            "かのちゃん",
            Color(0xFF39c5bb)
        )
    )
    val novel : MutableList<Novel> = mutableListOf(
        Novel(
            1,
            "《关于邻家的天使大人不知不觉把我惯成了废人这档子事》",
            0,
            and,
            "小说第10卷确定2024年9月发售",
            Color(0xFF39c5bb)
        ),
        Novel(
            2,
            "《关于转生到异世界成为抽象旺仔脸，并且被一众后辈簇拥这档子事》",
            99999,
            sensei,
            "已于2024年4月9发售，现绝赞上映中",
            Color(0xFF39c5bb)
        )
    )
}

