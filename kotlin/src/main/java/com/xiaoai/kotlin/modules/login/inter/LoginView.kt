package com.xiaoai.kotlin.modules.login.inter

import com.xiaoai.kotlin.bean.LoginRegisterResponse

interface LoginView {
    fun loginSuccess(loginRegisterResponse: LoginRegisterResponse?)

    fun loginFailure(errorMsg: String?)
}