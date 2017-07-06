package com.dct.survey.taishan.ui;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.utils.NetUtil;
import com.dct.survey.taishan.utils.ToastUtil;
import com.dct.survey.taishan.view.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建：Android
 * 日期：2017/7/6 14:34
 * 描述：登陆界面
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.name)
    MaterialEditText name;
    @BindView(R.id.password)
    MaterialEditText password;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    /**
     * 界面的点击事件
     * @param view
     */
    @OnClick({R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn: //登陆
                checkLogin();
                break;
        }
    }

    /**
     * 判断用户名和密码是否合法
     */
    private void checkLogin() {
        if(name.getText().toString().trim().equals("")){
            ToastUtil.show(LoginActivity.this,"请输入用户名", Toast.LENGTH_SHORT);
            return;
        }
        if(password.getText().toString().trim().equals("")){
            ToastUtil.show(LoginActivity.this,"请输入密码", Toast.LENGTH_SHORT);
            return;
        }
        if(password.getText().toString().length()<6){
            ToastUtil.show(LoginActivity.this,"密码不能少于6个字符", Toast.LENGTH_SHORT);
            return;
        }
        //验证通过之后执行登陆的网络请求
        doLogin();
    }

    /**
     * 执行登陆的网络请求
     */
    private void doLogin() {
        if (!NetUtil.isConnected(this)){
            ToastUtil.showShort(this, "网络未连接");
        }else {

        }
    }
}
