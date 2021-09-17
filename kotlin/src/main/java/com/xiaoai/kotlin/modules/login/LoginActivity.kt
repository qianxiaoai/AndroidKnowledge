package com.xiaoai.kotlin.modules.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.xiaoai.kotlin.R
import com.xiaoai.kotlin.base.BaseActivity
import com.xiaoai.kotlin.bean.LoginRegisterResponse
import com.xiaoai.kotlin.modules.login.inter.LoginPresenter
import com.xiaoai.kotlin.modules.login.inter.LoginView
import com.xiaoai.kotlin.test.JavaTest
import com.xiaoai.kotlin.test.KtTest
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        user_login_bt.setOnClickListener {

            val userNameStr = user_phone_et.text.toString()
            val userPwdStr = user_password_et.text.toString()
            Log.d(TAG, "userName:$userNameStr,  userPwd:$userPwdStr")

            presenter.loginAction(this@LoginActivity, userNameStr, userPwdStr)

        }
        KtTest().printOnlyKotlin("xiaoxiao kotlin")
        KtTest().printJava("xiaoxiao java")
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenterImpl(this)
    }

    override fun destroy() {
        presenter.unAttachView()
    }

    override fun loginSuccess(loginRegisterResponse: LoginRegisterResponse?) {
        Toast.makeText(this@LoginActivity, "登录成功!!!", Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(errorMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败~~~", Toast.LENGTH_SHORT).show()

    }
}