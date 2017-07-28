package cn.xavier.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import butterknife.ButterKnife;
import cn.xavier.base.utils.PrefUtil;
import cn.xavier.base.utils.swipeback.SwipeBackActivity;
import cn.xavier.base.utils.swipeback.SwipeBackLayout;

/**
 * Created by yangxh on 17/7/28.
 */

public abstract class BaseActivity extends SwipeBackActivity  {

    protected SwipeBackLayout mSwipeBackLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(PrefUtil.getThemeRes(this));
        setContentView(getLayoutId());
        mSwipeBackLayout=getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        ButterKnife.bind(this);
        afterCreate(savedInstanceState);
    }

    protected abstract void afterCreate(Bundle state);

    protected abstract int getLayoutId() ;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            scrollToFinishActivity();
        }
        return true;
    }
}
