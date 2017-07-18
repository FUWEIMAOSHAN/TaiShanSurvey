package com.dct.survey.taishans.ui.map;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dct.survey.taishans.R;
import com.dct.survey.taishans.base.BaseActivity;
import com.dct.survey.taishans.bean.DictionaryBean;
import com.dct.survey.taishans.bean.DictionaryLibrary;
import com.dct.survey.taishans.dao.DaoManager;
import com.dct.survey.taishans.dao.DictionaryLibraryDao;
import com.dct.survey.taishans.ui.adapter.DialogAdapter;
import com.dct.survey.taishans.utils.ToastUtil;
import com.dct.survey.taishans.utils.overscroll.OverScrollDecoratorHelper;
import com.dct.survey.taishans.view.pickview.OptionsPickerView;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建：Android
 * 日期：2017/7/10 9:23
 * 描述：添加调查点标记的界面
 */

public class TargetActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_size)
    TextView tvSize;
    @BindView(R.id.iv_inf)
    ImageView ivInf;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_level)
    TextView tvLevel;
    @BindView(R.id.iv_target)
    ImageView ivTarget;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    private DictionaryLibrary dictionaryLibrary;
    private DictionaryBean parentBean;

    @Override
    protected int getLayout() {
        return R.layout.layout_target;
    }

    @Override
    public void initView() {
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);
    }

    @Override
    public void initData() {
        DictionaryLibraryDao dictionaryLibraryDao = DaoManager.getInstance(this).getDictionaryLibraryDao();
        dictionaryLibrary = dictionaryLibraryDao.queryBuilder().build().unique();
    }

    @OnClick({R.id.back, R.id.delete, R.id.tv_type, R.id.tv_size, R.id.iv_inf, R.id.tv_year, R.id.tv_level, R.id.iv_target, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back: //返回
                finish();
                break;
            case R.id.delete: //删除
                break;
            case R.id.tv_type: //类型
                selectType();
                break;
            case R.id.tv_size: //规模
                selectSize();
                break;
            case R.id.iv_inf: //规模的提示信息
                showSizeInfo();
                break;
            case R.id.tv_year: //年代
                selectYear();
                break;
            case R.id.tv_level: //级别
                selectLevel();
                break;
            case R.id.iv_target: //标记点封面照片

                break;
            case R.id.btn_save: //保存
                break;
            default:
                break;
        }
    }

    /**
     * 选择级别
     */
    private void selectLevel() {
        final List<DictionaryBean> levelList = dictionaryLibrary.getLevel();
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                DictionaryBean yearBean = levelList.get(options1);
                tvLevel.setText(yearBean.getNAME());
            }
        }).setTitleText("级别选择").setContentTextSize(18).build();

        pickerView.setPicker(levelList);
        pickerView.show();
    }

    /**
     * 选择年代
     */
    private void selectYear() {
        final List<DictionaryBean> yearList = dictionaryLibrary.getYears();
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                DictionaryBean yearBean = yearList.get(options1);
                tvYear.setText(yearBean.getNAME());
            }
        }).setTitleText("年代选择").setContentTextSize(18).build();

        pickerView.setPicker(yearList);
        pickerView.show();
    }

    /**
     * 显示规模的提示信息
     */
    private void showSizeInfo() {
        if (parentBean == null) {
            ToastUtil.showShort(this, "请先选择类型");
            return;
        }
        DialogPlus dialog = DialogPlus.newDialog(this)
                .setAdapter(new DialogAdapter(parentBean.getLEVEL()))
                .setExpanded(false)
                .setMargin(60, 0, 60, 0)
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .create();
        dialog.show();
    }

    /**
     * 选择规模
     */
    private void selectSize() {
        if (parentBean == null) {
            ToastUtil.showShort(this, "请先选择类型");
            return;
        }
        final List<DictionaryBean> scaleList = parentBean.getLEVEL();
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                DictionaryBean scaleBean = scaleList.get(options1);
                tvSize.setText(scaleBean.getNAME());
            }
        }).setTitleText("规模选择").setContentTextSize(18).build();
        pickerView.setPicker(scaleList);
        pickerView.show();
    }

    /**
     * 选择标记点的类型
     */
    private void selectType() {
        final List<DictionaryBean> type1 = dictionaryLibrary.getType();
        List<List<DictionaryBean>> type2 = new ArrayList<>();
        final List<List<List<DictionaryBean>>> type3 = new ArrayList<>();
        for (DictionaryBean dictionaryBean : type1){
            type2.add(dictionaryBean.getTYPE());
            List<List<DictionaryBean>> listList = new ArrayList<>();
            for (DictionaryBean bean : dictionaryBean.getTYPE()) {
                listList.add(bean.getTYPE());
            }
            type3.add(listList);
        }
        OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                parentBean = type1.get(options1);
                DictionaryBean typeBean = type3.get(options1).get(options2).get(options3);
                tvType.setText(typeBean.getNAME());
            }
        }).setTitleText("类型选择").setContentTextSize(11).build();
        pickerView.setPicker(type1, type2, type3);
        pickerView.show();
    }
}
