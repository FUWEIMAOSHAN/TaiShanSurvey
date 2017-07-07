package com.dct.survey.taishan.ui.record;

import android.support.v7.widget.RecyclerView;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseFragment;
import com.dct.survey.taishan.view.progressactivity.ProgressLinearLayout;

import butterknife.BindView;

/**
 * 创建：Android
 * 日期：2017/7/7 8:27
 * 描述：我的记录的页面
 */

public class MineRecordFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressLinearLayout)
    ProgressLinearLayout progressLinearLayout;


    @Override
    protected int getLayout() {
        return R.layout.fragment_minerecord;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
