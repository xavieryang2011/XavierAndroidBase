package io.github.xavier.demo.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;
import io.github.xavier.demo.R;
import io.github.xavier.demo.base.DemoBaseActivity;
import io.github.xavier.demo.utils.Constant;
import io.github.xavier.demo.ui.adapter.NewsListAdapter;
import io.github.xavier.demo.ui.fragment.NewsListFragment;
import io.github.xavier.demo.utils.PrefUtil;

public class NewsListActivity extends DemoBaseActivity {

    @Bind(R.id.fl_main)
    ViewGroup mViewGroup;
    @Bind(R.id.iv_main)
    ImageView mIvMain;

    private final long ANIMTION_TIME = 1000;
    private NewsListFragment mFragment;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_list;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        addFragment(0, 0, null, null);
    }

    private void addFragment(int position, int scroll, NewsListAdapter adapter, String curDate) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mFragment != null) {
            transaction.remove(mFragment);
        }
        mFragment = NewsListFragment.newInstance(position, scroll, adapter, curDate);
        mFragment.setmOnRecyclerViewCreated(new onViewCreatedListener());
        transaction.replace(R.id.fl_container, mFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_action_about:
                AboutActivity.start(this);
                return true;

            case R.id.menu_action_daynight:
                boolean isNight = PrefUtil.isNight(this);
                if (isNight) {
                    PrefUtil.setDay(this);
                    setTheme(Constant.RESOURCES_DAYTHEME);
                } else {
                    PrefUtil.setNight(this);
                    setTheme(Constant.RESOURCES_NIGHTTHEME);
                }
                setDrawableCahe();
                getState();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    private void setDrawableCahe() {
        //设置false清除缓存
        mViewGroup.setDrawingCacheEnabled(false);
        //设置true之后可以获取Bitmap
        mViewGroup.setDrawingCacheEnabled(true);
        mIvMain.setImageBitmap(mViewGroup.getDrawingCache());
        mIvMain.setAlpha(1f);
        mIvMain.setVisibility(View.VISIBLE);
    }

    public void getState() {
        RecyclerView recyclerView = mFragment.getRecyclerView();
        recyclerView.stopScroll();
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int position = layoutManager.findFirstVisibleItemPosition();
            int scroll = recyclerView.getChildAt(0).getTop();
            addFragment(position, scroll, mFragment.getmNewsListAdapter(), mFragment.getCurDate());
        }
    }

    private void startAnimation(final View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(1f).setDuration(ANIMTION_TIME);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float n = (float) animation.getAnimatedValue();
                view.setAlpha(1f - n);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mIvMain.setVisibility(View.INVISIBLE);
            }
        });
        animator.start();
    }

    class onViewCreatedListener implements NewsListFragment.OnRecyclerViewCreated {

        @Override
        public void recyclerViewCreated() {
            startAnimation(mIvMain);
        }
    }
}
