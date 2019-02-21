package com.dev.sherry.main;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.sherry.home.HomeFragment;
import com.dev.sherry.R;
import com.dev.sherry.me.MeFragment;
import com.dev.sherry.queen.QueenFragment;
import com.dev.sherry.vip.VipFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //    private ViewGroup mHomeTabLayout;
//    private ViewGroup mVipTabLayout;
//    private ViewGroup mQueenTabLayout;
//    private ViewGroup mMeTabLayout;
//    private ImageView mHomeImageView;
//    private ImageView mVipImageView;
//    private ImageView mQueenImageView;
//    private ImageView mMeImageView;
//    private TextView mHomeText;
//    private TextView mVipText;
//    private TextView mQueenText;
//    private TextView mMeText;
//
//    private FragmentManager mFragmentManager;
//    private List<ImageView> mImageList;
//    private List<TextView> mTextViewList;
    private ViewPager mMainViewPager;
    private TabLayout mTabLayout;
    private MyPagerAdapter myPagerAdapter;

    private int[] mSelectedImageResId = {R.drawable.icon_home_selected
            , R.drawable.icon_vip_selected
            , R.drawable.icon_queen_selected
            , R.drawable.icon_me_selected};

    private int[] mUnSelectedImageResId = {R.drawable.icon_home_unselected
            , R.drawable.icon_vip_unselected
            , R.drawable.icon_queen_unselected
            , R.drawable.icon_me_unselected};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainViewPager = findViewById(R.id.view_pager_main);
        mTabLayout = findViewById(R.id.tab_layout_main);

        mTabLayout.setupWithViewPager(mMainViewPager);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new VipFragment());
        fragmentList.add(new QueenFragment());
        fragmentList.add(new MeFragment());

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        mMainViewPager.setAdapter(myPagerAdapter);

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragmentList;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.fragmentList = list;
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

//    private void initView() {

//        mHomeTabLayout = findViewById(R.id.ll_one);
//        mVipTabLayout = findViewById(R.id.ll_two);
//        mQueenTabLayout = findViewById(R.id.ll_three);
//        mMeTabLayout = findViewById(R.id.ll_four);
//
//        mHomeImageView = findViewById(R.id.iv_title_one);
//        mVipImageView = findViewById(R.id.iv_title_two);
//        mQueenImageView = findViewById(R.id.iv_title_three);
//        mMeImageView = findViewById(R.id.iv_title_four);
//
//        mHomeText = findViewById(R.id.tv_title_one);
//        mVipText = findViewById(R.id.tv_title_two);
//        mQueenText = findViewById(R.id.tv_title_three);
//        mMeText = findViewById(R.id.tv_title_four);
//        mHomeTabLayout.setOnClickListener(this);
//        mVipTabLayout.setOnClickListener(this);
//        mQueenTabLayout.setOnClickListener(this);
//        mMeTabLayout.setOnClickListener(this);
//
//        mImageList = new ArrayList<>();
//        mImageList.add(mHomeImageView);
//        mImageList.add(mVipImageView);
//        mImageList.add(mQueenImageView);
//        mImageList.add(mMeImageView);
//
//        mTextViewList = new ArrayList<>();
//        mTextViewList.add(mHomeText);
//        mTextViewList.add(mVipText);
//        mTextViewList.add(mQueenText);
//        mTextViewList.add(mMeText);

//        changeBottomType(0);
//        mFragmentManager = getSupportFragmentManager();
//        mFragmentManager.beginTransaction()
//                .add(R.id.main_frame, HomeFragment.newInstance(), HomeFragment.class.getCanonicalName())
//                .commit();
//    }

//    @Override
//    public void onClick(View v) {
//        FragmentTransaction transaction = mFragmentManager.beginTransaction();
//        switch (v.getId()) {
//            case R.id.ll_one:
//                changeBottomType(0);
//                Fragment fragmentHome = mFragmentManager.findFragmentByTag(HomeFragment.class.getCanonicalName());
//                if (fragmentHome == null) {
//                    transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out)
//                            .add(R.id.main_frame, HomeFragment.newInstance(), HomeFragment.class.getCanonicalName())
//                            .commit();
//                } else {
//                    transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out)
//                            .add(R.id.main_frame, HomeFragment.newInstance(), HomeFragment.class.getCanonicalName())
//                            .commit();
//                }
//                break;
//            case R.id.ll_two:
//                changeBottomType(1);
//                Fragment fragmentVip = mFragmentManager.findFragmentByTag(VipFragment.class.getCanonicalName());
//                if (fragmentVip == null) {
//                    transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out)
//                            .replace(R.id.main_frame, VipFragment.newInstance(), VipFragment.class.getCanonicalName())
//                            .commit();
//                } else {
//                    transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out)
//                            .replace(R.id.main_frame, VipFragment.newInstance(), VipFragment.class.getCanonicalName())
//                            .commit();
//                }
//                break;
//            case R.id.ll_three:
//                changeBottomType(2);
//                Fragment fragmentQueen = mFragmentManager.findFragmentByTag(QueenFragment.class.getCanonicalName());
//                if (fragmentQueen == null) {
//                    transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out)
//                            .replace(R.id.main_frame, QueenFragment.newInstance(), QueenFragment.class.getCanonicalName())
//                            .commit();
//                } else {
//                    transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out)
//                            .replace(R.id.main_frame, QueenFragment.newInstance(), QueenFragment.class.getCanonicalName())
//                            .commit();
//                }
//                break;
//            case R.id.ll_four:
//                changeBottomType(3);
//                Fragment fragmentMe = mFragmentManager.findFragmentByTag(MeFragment.class.getCanonicalName());
//                if (fragmentMe == null) {
//                    transaction
//                            .setCustomAnimations(R.anim.right_in, R.anim.left_out)
//                            .replace(R.id.main_frame, MeFragment.newInstance(), MeFragment.class.getCanonicalName())
//                            .commit();
//                } else {
//                    transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out)
//                            .replace(R.id.main_frame, MeFragment.newInstance(), MeFragment.class.getCanonicalName())
//                            .commit();
//                }
//                break;
//        }
//
//    }

//    private void changeBottomType(int position) {
//        for (int i = 0, z = mImageList.size(); i < z; i++) {
//            mImageList.get(i).setImageResource(mUnSelectedImageResId[i]);
//            mTextViewList.get(i).setTextColor(getResources().getColor(R.color.black));
//        }
//        mImageList.get(position).setImageResource(mSelectedImageResId[position]);
//        mTextViewList.get(position).setTextColor(getResources().getColor(R.color.blue));
//    }
}
