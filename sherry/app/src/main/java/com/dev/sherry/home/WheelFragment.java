package com.dev.sherry.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.dev.sherry.R;
import com.dev.sherry.base.BaseFragment;
import com.dev.sherry.utils.PreKeys;

/**
 * Created by Sherry on 2019/2/19.
 */
public class WheelFragment extends BaseFragment {
    private ImageView mImageView;

    public static Fragment newInstance(int resourceId) {
        WheelFragment fragment = new WheelFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PreKeys.EXTRA_KEY_DATA, resourceId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wheel;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mImageView = findViewById(R.id.iv_wheel_image);
        if (bundle != null) {
            int resourceId = bundle.getInt(PreKeys.EXTRA_KEY_DATA);
            mImageView.setImageResource(resourceId);
        }
    }
}
