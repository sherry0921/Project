package com.dev.sherry.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dev.sherry.R;
import com.dev.sherry.base.BaseFragment;

/**
 * Created by Sherry on 2019/2/20.
 */
public class MeFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    public static Fragment newInstance() {
        return new MeFragment();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
