package com.example.babytree.xiaoaidemo.thread;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {
    //启动线程的三种方式
    private static String TAG = "xiaoxiao";

    public static void startThread() throws ExecutionException, InterruptedException {
        UseThread t = new UseThread();
        t.start();

        UseRun run = new UseRun();
        new Thread(run).start();

        FutureTask<String> task = new FutureTask<>(new UseCall());
        new Thread(task).start();
        Log.i(TAG,"task return result:" + task.get());//可以带返回值
//        interrupt() 、 isInterrupted()、static方法interrupted()
        Thread.interrupted();

    }

    private static class UseCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            Log.i(TAG,"xiaoxiao UseCall:");
            return "I am the result";
        }
    }

    private static class UseThread extends Thread {
        @Override
        public void run() {
            Log.i(TAG,"xiaoxiao UseThread:");
        }
    }

    private static class UseRun implements Runnable {

        @Override
        public void run() {
            Log.i(TAG,"xiaoxiao UseRun:");
        }
    }
}
