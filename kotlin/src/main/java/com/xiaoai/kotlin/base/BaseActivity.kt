package com.xiaoai.kotlin.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    abstract fun createPresenter(): P

    abstract fun destroy()

    override fun onDestroy() {
        super.onDestroy()
        destroy()
    }
}