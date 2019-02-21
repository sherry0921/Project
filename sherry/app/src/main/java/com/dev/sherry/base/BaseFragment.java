package com.dev.sherry.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sherry on 2019/2/19.
 */
public abstract class BaseFragment extends Fragment {
    private View mCacheView;
    public Bundle bundle;
    public Handler handler = new Handler();

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCacheView = initView(inflater, container);
        if (bundle == null) {
            bundle = new Bundle();
        }
        return mCacheView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(savedInstanceState);
    }

    private View initView(LayoutInflater inflater, ViewGroup container) {
        /**
         * inflate的三个参数的含义：
         * main,root,true  --->  把main放到root里,main的长宽不失效
         * main,root,false ----> main不放到root中,root协助main确定它的长宽,亦不失效
         * main,null,true or false ----> main不放到任何容器内,长宽失效
         */
        return inflater.inflate(getLayoutId(), container, false);
    }

    public final <T extends View> T findViewById(int resId) {
        if (mCacheView == null) {
            return null;
        }
        return (T) mCacheView.findViewById(resId);
    }
}
