package com.dct.survey.taishan.ui.record;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建：Android
 * 日期：2017/7/6 14:02
 * 描述：记录界面
 */

public class RecordFragment extends BaseFragment {
    @BindView(R.id.segmentTabLayout)
    SegmentTabLayout segmentTabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private String[] mTitles = {"我的记录", "所有记录"};
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.fragment_record;
    }

    @Override
    public void initView() {
        mFragments.add(new MineRecordFragment());
        mFragments.add(new AllRecordFragment());
        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        segmentTabLayout.setTabData(mTitles);
        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);
        segmentTabLayout.setCurrentTab(0);
    }

    @Override
    public void initData() {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
