package com.example.babytree.xiaoaidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "xiaoxiao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "xiaoxiao  onCreate");//可以带返回值

        reverse(1534236469);
    }




    public int reverse(int x) {

        int temp = x;
        boolean isN = false;

        if(x <= 9 && x >= -9){
            return x;
        }
        if(x<0) {
            isN = true;
            temp = -temp;
        }

        long result = 0;

        while(temp/10 > 0){
            result =result*10 + temp%10;
            temp =  temp/10;
        }
        result = result*10 + temp;

        if(isN){
            result = -result;
        }
        if(result > Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }

}
