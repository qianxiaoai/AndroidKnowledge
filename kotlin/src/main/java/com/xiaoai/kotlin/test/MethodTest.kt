package com.xiaoai.kotlin.test

fun main() {
    mood(true) {
        if (it > 4) {
            "玩了${it}小时,开心"
        } else {
            "玩了${it}小时,时间太少，不开心"
        }
    }
}

fun mood(isWork: Boolean, play: (Int) -> String) {
    if (isWork) {
        val result = play(1)
        print("工作：玩1小时：心情：$result")
    } else {
        val result = play(8)
        print("不工作，玩8小时：心情：$result")
    }
}