package com.dct.survey.taishan.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.utils.SpUtil;

import butterknife.BindView;

/**
 * 创建：Android
 * 日期：2017/7/6 12:01
 * 描述：闪屏界面
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected int getLayout() {
        return R.layout.activity_spalsh;
    }

    @Override
    public void initView() {
        ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(image, "alpha", 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                boolean isLogin = SpUtil.getBoolean(SplashActivity.this, "isLogin", false);
                if (isLogin){ //已经登陆直接进入主界面
                    startActivity(new Intent(SplashActivity.this,  MainActivity.class));
                }else { //未登陆进入登陆界面
                    startActivity(new Intent(SplashActivity.this,  LoginActivity.class));
                }
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void initData() {

    }
}
