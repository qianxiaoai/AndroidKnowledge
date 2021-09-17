package com.xiaoai.kotlin.modules.login

import android.content.Context
import com.xiaoai.kotlin.bean.LoginRegisterResponse
import com.xiaoai.kotlin.modules.login.inter.LoginPresenter
import com.xiaoai.kotlin.modules.login.inter.LoginView

class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.onLoginListener {

    private val loginModule: LoginModuleImpl = LoginModuleImpl()

    override fun loginAction(context: Context, username: String, passward: String) {
        loginModule.login(context, username, passward, this)
    }

    override fun unAttachView() {
        loginView = null
        loginModule.cancelRequest()
    }

    override fun onAttachView() {

    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg)
    }
}