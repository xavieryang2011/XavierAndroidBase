package io.github.xavier.base;

import android.app.Application;
import android.content.Context;

import io.github.xavier.base.utils.AppContextUtil;
import io.github.xavier.base.utils.L;

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
