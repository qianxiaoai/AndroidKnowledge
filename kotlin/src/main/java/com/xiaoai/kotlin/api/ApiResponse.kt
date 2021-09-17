package com.xiaoai.kotlin.api

import android.content.Context
import android.widget.Toast
import com.xiaoai.kotlin.bean.LoginRegisterResponseWrapper
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class ApiResponse<T>(val context: Context) : Observer<LoginRegisterResponseWrapper<T>> {

    abstract fun success(data: T?)
    abstract fun failure(msg: String?)


    override fun onSubscribe(d: Disposable) {
        //开始分发
        Toast.makeText(context, "开始请求", Toast.LENGTH_SHORT).show()
    }

    override fun onNext(t: LoginRegisterResponseWrapper<T>) {
        if (t.data == null) {
            Toast.makeText(context, "数据为空", Toast.LENGTH_SHORT).show()
            failure(t.errorMsg)
        } else {
            Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show()
            success(t.data)
        }
    }

    override fun onError(e: Throwable) {
        failure(e.message)
        Toast.makeText(context, "发生错误", Toast.LENGTH_SHORT).show()
    }

    override fun onComplete() {
        Toast.makeText(context, "请求结束", Toast.LENGTH_SHORT).show()
    }

}