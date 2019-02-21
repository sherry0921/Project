package com.dev.sherry.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.dev.sherry.R;
import com.dev.sherry.base.BaseFragment;

/**
 * Created by Sherry on 2019/2/19.
 */
public class HomeFragment extends BaseFragment {
    private static final int DELAY_TIME = 3000;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private int[] mImageResource;
    private int itemPosition;

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);
        //设置viewPager父容器的长宽.
        ViewGroup viewGroup = findViewById(R.id.rl_layout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
        int margin = getResources().getDimensionPixelOffset(R.dimen.common_margin);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels - margin - margin;
        layoutParams.width = width;
        layoutParams.height = width / 4;
        viewGroup.setLayoutParams(layoutParams);
        //封装数据
        mImageResource = new int[]{R.drawable.icon_one, R.drawable.icon_two, R.drawable.icon_three};
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MyPageAdapter(getChildFragmentManager(), mImageResource));
        mTabLayout.setupWithViewPager(mViewPager, true);

        handler.removeCallbacks(runnableForViewPager);
        handler.postDelayed(runnableForViewPager, DELAY_TIME);
    }

    //定时循环
    Runnable runnableForViewPager = new Runnable() {
        @Override
        public void run() {
            try {
                itemPosition++;
                handler.postDelayed(this, DELAY_TIME);
                mViewPager.setCurrentItem(itemPosition % mImageResource.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private class MyPageAdapter extends FragmentStatePagerAdapter {
        int[] list;

        public MyPageAdapter(FragmentManager fm, int[] data) {
            super(fm);
            this.list = data;
        }

        @Override
        public Fragment getItem(int i) {
            return WheelFragment.newInstance(list[i]);
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableForViewPager);
    }
}
