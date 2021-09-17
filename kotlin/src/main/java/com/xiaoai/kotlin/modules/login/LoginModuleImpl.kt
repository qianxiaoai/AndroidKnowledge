package com.xiaoai.kotlin.modules.login

import android.content.Context
import com.xiaoai.kotlin.api.ApiClient
import com.xiaoai.kotlin.api.ApiResponse
import com.xiaoai.kotlin.api.WanAndroidApi
import com.xiaoai.kotlin.bean.LoginRegisterResponse
import com.xiaoai.kotlin.modules.login.inter.LoginModule
import com.xiaoai.kotlin.modules.login.inter.LoginPresenter
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModuleImpl : LoginModule {
    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: LoginPresenter.onLoginListener
    ) {
        ApiClient.instanceRetrofit(WanAndroidApi::class.java)
            .loginAction(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    onLoginListener.loginSuccess(data)
                }

                override fun failure(msg: String?) {
                    onLoginListener.loginFailure(msg)
                }
            })
    }
}