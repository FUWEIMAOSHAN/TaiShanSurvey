package com.dct.survey.taishan.ui.map;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.bean.Dictionary;
import com.dct.survey.taishan.dao.DictionaryDao;
import com.dct.survey.taishan.dao.GreenDaoManager;
import com.dct.survey.taishan.view.pickview.OptionsPickerView;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
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

    @Override
    protected int getLayout() {
        return R.layout.layout_target;
    }

    @Override
    public void initView() {
        String addressName = getIntent().getStringExtra("addressName");
        if (!TextUtils.isEmpty(addressName)){ //添加标记
            location.setText(addressName);
        }else { //编辑标记

        }
    }

    @Override
    public void initData() {
        DictionaryDao dictionaryDao = GreenDaoManager.getInstance(this).getDaoSession().getDictionaryDao();
        QueryBuilder<Dictionary> builder = dictionaryDao.queryBuilder();
        List<Dictionary> list = builder.build().list();
        Logger.d(list.size());
        List<Dictionary> gradeLists = builder.where(DictionaryDao.Properties.CODE.eq("1134")).build().list();
        List<Dictionary> typeLists = builder.where(DictionaryDao.Properties.CODE.eq("113504")).build().list();
        types = new ArrayList<>();
        grades = new ArrayList<>();
        for (Dictionary dictionary : typeLists){
            String type = dictionary.getKEYNAME();
            types.add(type);
        }
        for (Dictionary dictionary : gradeLists){
            String grade = dictionary.getKEYNAME();
            grades.add(grade);
        }
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
}
