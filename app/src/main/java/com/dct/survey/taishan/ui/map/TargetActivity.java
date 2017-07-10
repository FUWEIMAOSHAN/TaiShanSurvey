package com.dct.survey.taishan.ui.map;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;

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

    @Override
    protected int getLayout() {
        return R.layout.layout_target;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

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
                break;
            case R.id.grade: //等级
                break;
            case R.id.image://图片
                break;
            default:
                break;
        }
    }
}
