package com.example.xiaoaidemo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.xiaoai.kotlin.base.BaseActivity;
import com.xiaoai.kotlin.base.IBasePresenter;
import com.xiaoai.kotlin.modules.login.LoginActivity;


public class MainActivity extends BaseActivity {

    private static String TAG = "xiaoxiao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "xiaoxiao  onCreate");//可以带返回值

        reverse(1534236469);

        String[] permission = new String[]{"android.permission.INTERNET"};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), permission[0]) != 0) {
            ActivityCompat.requestPermissions(this, permission, 123);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public int reverse(int x) {

        int temp = x;
        boolean isN = false;

        if (x <= 9 && x >= -9) {
            return x;
        }
        if (x < 0) {
            isN = true;
            temp = -temp;
        }

        long result = 0;

        while (temp / 10 > 0) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        result = result * 10 + temp;

        if (isN) {
            result = -result;
        }
        if (result > Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    @NonNull
    @Override
    public IBasePresenter createPresenter() {
        return new IBasePresenter() {
            @Override
            public void unAttachView() {

            }

            @Override
            public void onAttachView() {

            }
        };
    }

    @Override
    public void destroy() {

    }

    public void startLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
