package com.dct.survey.taishan.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.bean.DictionaryLibrary;
import com.dct.survey.taishan.bean.LoginBean;
import com.dct.survey.taishan.bean.UserBean;
import com.dct.survey.taishan.bean.WorkSiteBean;
import com.dct.survey.taishan.dao.DaoManager;
import com.dct.survey.taishan.http.RetrofitHttp;
import com.dct.survey.taishan.utils.Md5Util;
import com.dct.survey.taishan.utils.NetUtil;
import com.dct.survey.taishan.utils.SpUtil;
import com.dct.survey.taishan.utils.ToastUtil;
import com.dct.survey.taishan.view.PowerfulEditText;
import com.dct.survey.taishan.view.loadingdialog.LoadingDialog;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建：Android
 * 日期：2017/7/6 14:34
 * 描述：登陆界面
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.name)
    PowerfulEditText name;
    @BindView(R.id.password)
    PowerfulEditText password;
    @BindView(R.id.login_btn)
    Button loginBtn;

    private LoadingDialog loadingDialog;
    private int offSet = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        //用户名和密码数据的回显
        String userName = SpUtil.getString(this, "userName", "");
        String passWord = SpUtil.getString(this, "passWord", "");
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord)){
            name.setText(userName);
            password.setText(passWord);
        }
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
            case R.id.login_btn: //登陆的事件
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
            ToastUtil.showShort(this, "网连接未连接");
        }else {
            loadingDialog = new LoadingDialog(this);
            loadingDialog.setInterceptBack(false);
            loadingDialog.setLoadingText("正在登陆中...");
            loadingDialog.show();

            String username = name.getText().toString().trim();
            String psd = password.getText().toString().trim();
            Map<String, String> map = new HashMap<>();
            map.put("UserName", username);
            map.put("PassWord", Md5Util.getMD5(psd));

            RetrofitHttp.getRetrofit().login(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DefaultObserver<LoginBean>() {
                        @Override
                        public void onNext(@NonNull LoginBean loginBean) {
                            boolean isTrue = loginBean.isIsTrue();
                            if (isTrue){
                                getAllUserInfo();
                                getDictionary();
                                getWorkSite();
                                SpUtil.putString(LoginActivity.this, "userName", name.getText().toString().trim());
                                SpUtil.putString(LoginActivity.this, "passWord", password.getText().toString().trim());
                                UserBean currentUser = DaoManager.getInstance(LoginActivity.this).getCurrentUser(name.getText().toString().trim());
                                SpUtil.putString(LoginActivity.this, "guid", currentUser.getGUID());
                                ToastUtil.showShort(LoginActivity.this, "登陆成功");
                                loadingDialog.close();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                ToastUtil.showShort(LoginActivity.this, "登陆失败");
                                loadingDialog.close();
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Logger.d(e.getMessage());
                            ToastUtil.showShort(LoginActivity.this, "网络不给力");
                            loadingDialog.close();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    /**
     * 获取工地的信息
     */
    private void getWorkSite() {
        if (!NetUtil.isConnected(this)){
            ToastUtil.showShort(this, "网连接未连接");
        }else {
            RetrofitHttp.getRetrofit().getWorkSite().subscribeOn(Schedulers.io()).subscribe(new Consumer<List<WorkSiteBean>>() {
                @Override
                public void accept(@NonNull List<WorkSiteBean> workSiteBeens) throws Exception {
                    for (WorkSiteBean workSiteBean : workSiteBeens) {
                        DaoManager.getInstance(LoginActivity.this).getWorkSiteBeanDao().insertOrReplace(workSiteBean);
                    }
                }
            });
        }
    }

    /**
     * 获取字典数据
     */
    private void getDictionary() {
        if (!NetUtil.isConnected(this)){
            ToastUtil.showShort(this, "网连接未连接");
        }else {
            RetrofitHttp.getRetrofit().getDictionary().subscribeOn(Schedulers.io()).subscribe(new Consumer<DictionaryLibrary>() {
                @Override
                public void accept(@NonNull DictionaryLibrary dictionaryLibrary) throws Exception {
                    DaoManager.getInstance(LoginActivity.this).getDictionaryLibraryDao().insertOrReplace(dictionaryLibrary);
                }
            });
        }
    }

    /**
     * 获取所有用户的信息
     */
    private void getAllUserInfo() {
        if (!NetUtil.isConnected(this)){
            ToastUtil.showShort(this, "网连接未连接");
        }else {
            RetrofitHttp.getRetrofit().getAllUserInfo().subscribeOn(Schedulers.io()).subscribe(new Consumer<List<UserBean>>() {
                @Override
                public void accept(@NonNull List<UserBean> userBeens) throws Exception {
                    for (UserBean userBean : userBeens) {
                        DaoManager.getInstance(LoginActivity.this).getUserBeanDao().insertOrReplace(userBean);
                    }
                }
            });
        }
    }

    /**
     * 一行代码实现Android软键盘与EditText的交互
     * @return
     */
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.name, R.id.password};
        return ids;
    }
}
