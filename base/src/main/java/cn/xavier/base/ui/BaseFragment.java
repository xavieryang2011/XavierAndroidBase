package cn.xavier.base.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by yangxh on 17/7/28.
 */

public abstract class BaseFragment extends Fragment {
    public static String TAG=BaseFragment.class.getSimpleName();
    protected View mRootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(getLayoutId(),container,false);
        return mRootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        afterCreate(savedInstanceState);

    }

    protected abstract void afterCreate(Bundle savedInstanceState);

    protected abstract int getLayoutId() ;
}
