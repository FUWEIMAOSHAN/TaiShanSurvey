package com.dct.survey.taishan.ui;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.bean.TabEntity;
import com.dct.survey.taishan.ui.map.MapFragment;
import com.dct.survey.taishan.ui.record.RecordFragment;
import com.dct.survey.taishan.ui.user.UserFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.mian_fl_content)
    FrameLayout mianFlContent;
    @BindView(R.id.commonTablayout)
    CommonTabLayout commonTablayout;

    private long exitStartTime;
    private ArrayList<Fragment> fragments;
    private String[] mTitles = {"地图", "记录", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.map, R.drawable.record, R.drawable.user};
    private int[] mIconSelectIds = {
            R.drawable.map_press, R.drawable.record_press, R.drawable.user_press};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initFragment();
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        //给tab设置数据和关联的fragment
        commonTablayout.setTabData(mTabEntities, this, R.id.mian_fl_content, fragments);
        commonTablayout.setCurrentTab(0);
    }

    @Override
    public void initData() {

    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MapFragment());
        fragments.add(new RecordFragment());
        fragments.add(new UserFragment());
    }

    /**
     * 重写返回键事件
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            long now = System.currentTimeMillis();
            if (now - exitStartTime < 2000) {
                finish();
                System.exit(0);
            } else {
                exitStartTime = now;
                Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
