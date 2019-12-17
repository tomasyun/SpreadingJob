package com.yhrj.spreadingjob;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

public class YhSoftApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean b) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("application", " onViewInitFinished is " + b);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
