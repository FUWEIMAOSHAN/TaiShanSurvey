package com.dct.survey.taishan.ui.record;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseFragment;
import com.dct.survey.taishan.view.progressactivity.ProgressLinearLayout;
import com.dct.survey.taishan.view.springview.DefaultFooter;
import com.dct.survey.taishan.view.springview.DefaultHeader;
import com.dct.survey.taishan.view.springview.SpringView;

import butterknife.BindView;

/**
 * 创建：Android
 * 日期：2017/7/7 8:27
 * 描述：所有记录的页面
 */

public class AllRecordFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.progressLinearLayout)
    ProgressLinearLayout progressLinearLayout;

    @Override
    protected int getLayout() {
        return R.layout.fragment_minerecord;
    }

    @Override
    public void initView() {
        initSpringView();
    }

    @Override
    public void initData() {

    }

    /**
     * 设置下拉刷新加载更多
     */
    private void initSpringView() {
        springView.setType(SpringView.Type.FOLLOW);
        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        springView.setEnable(true);
                        springView.onFinishFreshAndLoad();
                    }
                }, 200);
            }

            @Override
            public void onLoadmore() {
//                if (CURRENT_PAGE >= TOTAL_PAGE) {
//                    Toasty.normal(mContext, "没有更多数据了...").show();
//                    springView.onFinishFreshAndLoad();
//                } else {
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            getAllOrderData(++CURRENT_PAGE);
//                            springView.onFinishFreshAndLoad();
//                        }
//                    }, 10);
//                }
            }
        });
    }
}
