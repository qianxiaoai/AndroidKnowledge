package com.xiaoai.kotlin.modules.login.inter

import android.content.Context

interface LoginModule {

    fun cancelRequest()

    fun login(
        context: Context, username: String, password: String,
        onLoginListener: LoginPresenter.onLoginListener//数据给P层
    )


}