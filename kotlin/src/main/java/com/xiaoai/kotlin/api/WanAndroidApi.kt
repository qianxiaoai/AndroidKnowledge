package com.xiaoai.kotlin.api

import com.xiaoai.kotlin.bean.LoginRegisterResponse
import com.xiaoai.kotlin.bean.LoginRegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanAndroidApi {

    /**
     * 登录
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(@Field("username") username:String,
                    @Field("password") password:String
    ): Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>>

    /**
     * 注册
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(@Field("username") username: String,
                       @Field("password") password: String,
                       @Field("repassword") repassword: String)
            : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>> // 返回值
}