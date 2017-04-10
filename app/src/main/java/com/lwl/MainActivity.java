package com.lwl;

import android.widget.RadioGroup;

import com.lwl.base.BasePresenter;
import com.lwl.base.MVPBaseActivity;
//import com.lwl.home.HomeFragment;
//import com.lwl.live.LiveFragment;
//import com.lwl.mine.MineFragment;
import com.lwl.video.view.VideoFragment;
import com.lwl.neteasenews.R;


import butterknife.Bind;

public class MainActivity extends MVPBaseActivity {
    @Bind(R.id.rg)
    RadioGroup mRadioGroup;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:

//                        showFragment(R.id.main_frame, new HomeFragment());
                        break;
                    case R.id.rb2:

//                        showFragment(R.id.main_frame, new LiveFragment());
                        break;
                    case R.id.rb3:
                        showFragment(R.id.main_frame, new VideoFragment());
                        break;
                    case R.id.rb4:
//                        showFragment(R.id.main_frame, new MineFragment());
                        break;
                }
            }
        });
    }
}
