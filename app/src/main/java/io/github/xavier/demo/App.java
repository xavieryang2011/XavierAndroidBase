package io.github.xavier.demo;

import android.app.Application;
import android.content.Context;

import cn.xavier.base.utils.AppContextUtil;
import cn.xavier.base.utils.L;

/**
 * Created by xavier on 16/3/17.
 */
public class App extends Application {

    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
        AppContextUtil.init(this);
        L.init();
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mApplicationContext;
    }
}
