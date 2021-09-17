package com.xiaoai.kotlin.modules.login.inter

import android.content.Context
import com.xiaoai.kotlin.base.IBasePresenter
import com.xiaoai.kotlin.bean.LoginRegisterResponse

interface LoginPresenter : IBasePresenter {

    fun loginAction(context: Context, username: String, passward: String)

    interface onLoginListener {
        fun loginSuccess(loginBean: LoginRegisterResponse?)
        fun loginFailure(errorMsg: String?)
    }
}