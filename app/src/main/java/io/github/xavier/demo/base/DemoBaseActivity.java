package io.github.xavier.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import cn.xavier.base.ui.BaseActivity;
import io.github.xavier.demo.utils.PrefUtil;

/**
 * Created by yangxh on 17/8/4.
 */

public  class DemoBaseActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(PrefUtil.getThemeRes(this));//多主题
    }

    @Override
    protected void afterCreate(Bundle state) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
