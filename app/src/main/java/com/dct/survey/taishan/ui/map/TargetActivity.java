package com.dct.survey.taishan.ui.map;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.bean.SurveyTarget;
import com.dct.survey.taishan.dao.DaoManager;
import com.dct.survey.taishan.utils.CurrentDate;
import com.dct.survey.taishan.utils.ToastUtil;
import com.dct.survey.taishan.utils.UUID;
import com.dct.survey.taishan.view.pickview.OptionsPickerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建：Android
 * 日期：2017/7/10 9:23
 * 描述：添加mark标记的界面
 */

public class TargetActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.head_layout)
    RelativeLayout headLayout;
    @BindView(R.id.save)
    Button save;
    @BindView(R.id.bottom_layout)
    RelativeLayout bottomLayout;
    @BindView(R.id.name_text)
    TextView nameText;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.no_text)
    TextView noText;
    @BindView(R.id.no)
    EditText no;
    @BindView(R.id.loc_text)
    TextView locText;
    @BindView(R.id.location)
    EditText location;
    @BindView(R.id.tgttype_text)
    TextView tgttypeText;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.tgttype_layout)
    RelativeLayout tgttypeLayout;
    @BindView(R.id.grade_text)
    TextView gradeText;
    @BindView(R.id.grade)
    TextView grade;
    @BindView(R.id.grade_layout)
    RelativeLayout gradeLayout;
    @BindView(R.id.img_text)
    TextView imgText;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.content_layout)
    ScrollView contentLayout;

    private List<String> types; //类型
    private List<String> grades; //等级
    private LatLng latLng;

    @Override
    protected int getLayout() {
        return R.layout.layout_target;
    }

    @Override
    public void initView() {
        latLng = getIntent().getParcelableExtra("latLng");
        if (null != latLng){ //添加标记
            getMarkLocationName();
        }else { //编辑标记

        }
    }

    @Override
    public void initData() {
        grades = DaoManager.getInstance(this).getGrade();
        types = DaoManager.getInstance(this).getType();
    }

    @OnClick({R.id.back, R.id.delete, R.id.save, R.id.type, R.id.grade, R.id.image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back: //返回
                finish();
                break;
            case R.id.delete: //删除
                break;
            case R.id.save: //保存
                saveTarget();
                break;
            case R.id.type: //类型
                selectType();
                break;
            case R.id.grade: //等级
                selectGrade();
                break;
            case R.id.image://图片
                break;
            default:
                break;
        }
    }

    /**
     * 保存标记的方法
     */
    private void saveTarget() {
        String selectType = this.type.getText().toString().trim();
        if (TextUtils.isEmpty(selectType)){
            ToastUtil.showShort(this, "请选择标记的类型");
        }else {
            SurveyTarget surveyTarget = new SurveyTarget();
            surveyTarget.setNAME(name.getText().toString().trim());
            surveyTarget.setADDRESS(location.getText().toString().trim());
            surveyTarget.setGRADE(DaoManager.getInstance(this).getNoFromName(grade.getText().toString().trim()));
            surveyTarget.setTGTTYPE(DaoManager.getInstance(this).getNoFromName(type.getText().toString().trim()));
            surveyTarget.setZ("0");
            surveyTarget.setN(String.valueOf(latLng.latitude));
            surveyTarget.setE(String.valueOf(latLng.longitude));
            surveyTarget.setGUID(UUID.getUUID());
            surveyTarget.setSTATE("-2");
            surveyTarget.setUPDATETIME(CurrentDate.getmm());
        }
    }

    /**
     * 选择等级
     */
    private void selectGrade() {
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String selectGrade = grades.get(options1);
                grade.setText(selectGrade);
            }
        }).setContentTextSize(18).setSelectOptions(0).build();
        pickerView.setPicker(grades);
        pickerView.show();
    }

    /**
     * 选择类型
     */
    private void selectType() {
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String selectType = types.get(options1);
                type.setText(selectType);
            }
        }).setContentTextSize(18).setSelectOptions(0).build();
        pickerView.setPicker(types);
        pickerView.show();
    }

    /**
     * 利用高德地图的解码坐标得到具体的地理名称
     */
    private void getMarkLocationName() {
        GeocodeSearch geocodeSearch = new GeocodeSearch(this);
        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            @Override
            public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
                if (rCode == AMapException.CODE_AMAP_SUCCESS) {
                    if (result != null && result.getRegeocodeAddress() != null
                            && result.getRegeocodeAddress().getFormatAddress() != null) {
                        String addressName = result.getRegeocodeAddress().getFormatAddress() + "附近";
                        location.setText(addressName);
                    } else {
                        ToastUtil.showShort(TargetActivity.this, "对不起，没有搜索到相关的数据");
                    }
                } else {
                    ToastUtil.showShort(TargetActivity.this, "对不起，位置编码错误");
                }
            }

            @Override
            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {}
        });
        if (latLng != null) {
            RegeocodeQuery query = new RegeocodeQuery(new LatLonPoint(latLng.latitude, latLng.longitude), 200, GeocodeSearch.AMAP);
            geocodeSearch.getFromLocationAsyn(query);
        }
    }

}
