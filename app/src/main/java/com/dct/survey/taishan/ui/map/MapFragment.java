package com.dct.survey.taishan.ui.map;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseFragment;
import com.dct.survey.taishan.utils.Constants;
import com.dct.survey.taishan.utils.KeyBoardUtils;
import com.dct.survey.taishan.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 创建：Android
 * 日期：2017/7/6 14:02
 * 描述：地图界面
 */

public class MapFragment extends BaseFragment {

    @BindView(R.id.map)
    MapView mapView;
    @BindView(R.id.map_search)
    AutoCompleteTextView mapSearch;
    @BindView(R.id.select_text)
    TextView selectText;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.map_select_layout)
    RelativeLayout mapSelectLayout;
    @BindView(R.id.search_layout)
    RelativeLayout searchLayout;
    @BindView(R.id.traffic)
    ImageView traffic;
    @BindView(R.id.weixing)
    ImageView weixing;
    @BindView(R.id.road)
    ImageView road;
    @BindView(R.id.people)
    ImageView people;
    @BindView(R.id.refresh)
    ImageView refresh;
    @BindView(R.id.lock)
    ImageView lock;
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.clear)
    TextView clear;
    @BindView(R.id.left_title_layout)
    LinearLayout leftTitleLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.commit_layout)
    RelativeLayout commitLayout;
    @BindView(R.id.rl_drawer)
    RelativeLayout rlDrawer;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private AMap aMap;
    private static final int STROKE_COLOR = Color.argb(180, 3, 145, 255);
    private static final int FILL_COLOR = Color.argb(10, 0, 0, 180);
    private View inflate;
    private Unbinder unbinder;

    /**
     * 界面的点击事件
     * @param view
     */
    @OnClick({R.id.select_text, R.id.traffic, R.id.weixing, R.id.road, R.id.people, R.id.refresh, R.id.lock, R.id.location, R.id.clear, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_text: //地图选点
                break;
            case R.id.traffic: //路况
                break;
            case R.id.weixing: //卫星
                break;
            case R.id.road: //线路
                break;
            case R.id.people: //人员
                break;
            case R.id.refresh: //刷新
                break;
            case R.id.lock: //锁定
                break;
            case R.id.location: //定位
                break;
            case R.id.clear: //清除
                break;
            case R.id.commit: //提交
                break;
            default:
                break;
        }
    }

    /**
     * 高德地图生命周期配置
     * @param savedInstanceState
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (null == inflate) {
            inflate = LayoutInflater.from(container.getContext()).inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, inflate);
        }else {
            unbinder = ButterKnife.bind(this, inflate);
        }
        mapView.onCreate(savedInstanceState);
        initView();
        initData();
        return inflate;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_map;
    }

    @Override
    public void initView() {
        StatusBarUtil.setStatusBarTranslucent(getActivity(), true);
        KeyBoardUtils.hideInputForce(getActivity());
        initMap();
        initLocation();
    }

    @Override
    public void initData() {

    }

    /**
     * 初始化地图的定位
     */
    private void initLocation() {
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.getUiSettings().setMyLocationButtonEnabled(false);// 设置默认定位按钮是否显示
        MyLocationStyle myLocationStyle = new MyLocationStyle();// 自定义系统定位蓝点
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.gps_point)); // 自定义定位蓝点图标
        myLocationStyle.strokeColor(STROKE_COLOR);// 自定义精度范围的圆形边框颜色
        myLocationStyle.strokeWidth(5);//自定义精度范围的圆形边框宽度
        myLocationStyle.radiusFillColor(FILL_COLOR); // 设置圆形的填充颜色
        myLocationStyle.showMyLocation(true); //设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）默认执行此种模式。
        aMap.setMyLocationStyle(myLocationStyle); // 将自定义的 myLocationStyle 对象添加到地图上
        aMap.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() { //从location对象中获取经纬度信息，地址描述信息，建议拿到位置之后调用逆地理编码接口获取
            @Override
            public void onMyLocationChange(Location location) {

            }
        });
    }
    /**
     * 初始化高德地图
     */
    private void initMap() {
        if (null == aMap){
            aMap = mapView.getMap();
            aMap.getUiSettings().setScaleControlsEnabled(true);//添加比例尺
            aMap.getUiSettings().setRotateGesturesEnabled(false);//禁止地图旋转
            aMap.showIndoorMap(true);//显示室内地图
            aMap.moveCamera(CameraUpdateFactory.zoomTo(Constants.InitZoom));//默认缩放等级
            initMapListener();
        }
    }

    /**
     * 初始化地图的监听事件
     */
    private void initMapListener() {
        if (aMap != null){
            aMap.setOnMapTouchListener(new AMap.OnMapTouchListener() {
                @Override
                public void onTouch(MotionEvent motionEvent) {
                    switch (motionEvent.getAction()){
                        case MotionEvent.ACTION_MOVE:
                            //设置定位模式

                            break;
                    }
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
