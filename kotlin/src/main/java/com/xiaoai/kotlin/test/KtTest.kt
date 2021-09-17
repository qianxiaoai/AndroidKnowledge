package com.xiaoai.kotlin.test

class KtTest {
    fun printJava(string: String) {
        println(string)
    }

    fun `printOnlyKotlin`(string: String) {
        println(string)
    }

    fun `12345`() {
        println("12345")
    }

    fun test() {
        printJava("haha")
        printOnlyKotlin("kotlin")
        `printOnlyKotlin`("kotlin")
        `12345`()
    }


}