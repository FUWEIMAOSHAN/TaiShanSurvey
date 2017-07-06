package com.dct.survey.taishan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建：Android
 * 日期：2017/7/6 12:58
 * 描述：所有Fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    private View inflate;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (null == inflater) {
            inflate = LayoutInflater.from(container.getContext()).inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, inflate);
        }else {
            unbinder = ButterKnife.bind(this, inflate);
        }
        initView();
        initData();
        return inflate;
    }

    /**
     * 加载布局的方法，子类必须实现
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化界面
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 界面销毁的生命方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
