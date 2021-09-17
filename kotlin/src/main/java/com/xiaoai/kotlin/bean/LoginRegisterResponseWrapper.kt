package com.xiaoai.kotlin.bean

/**
 * 包装Bean

{
"data": {
"admin": false,
"chapterTops": [],
"collectIds": [],
"email": "",
"icon": "",
"id": 123,
"nickname": "xiaoai",
"password": "",
"publicName": "xiaoai",
"token": "",
"type": 0,
"username": "xiaoai"
},
"errorCode": 0,
"errorMsg": ""
}

{
"data": null,
"errorCode": -1,
"errorMsg": "账号密码不匹配！"
}

 */
data class LoginRegisterResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String)