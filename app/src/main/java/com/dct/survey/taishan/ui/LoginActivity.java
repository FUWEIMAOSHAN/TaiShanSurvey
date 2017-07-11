package com.dct.survey.taishan.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dct.survey.taishan.R;
import com.dct.survey.taishan.base.BaseActivity;
import com.dct.survey.taishan.bean.Dictionary;
import com.dct.survey.taishan.bean.UserBean;
import com.dct.survey.taishan.bean.UserInfo;
import com.dct.survey.taishan.dao.DaoSession;
import com.dct.survey.taishan.dao.DictionaryDao;
import com.dct.survey.taishan.dao.GreenDaoManager;
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
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
    private DictionaryDao dictionaryDao;

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
        DaoSession daoSession = GreenDaoManager.getInstance(LoginActivity.this).getDaoSession();
        dictionaryDao = daoSession.getDictionaryDao();
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
                    .subscribe(new DefaultObserver<UserBean>() {
                        @Override
                        public void onNext(@NonNull UserBean userBean) {
                            boolean isTrue = userBean.isIsTrue();
                            if (isTrue){
                                getAllUserInfo();
                                getDictionary(0);
                                SpUtil.putString(LoginActivity.this, "userName", name.getText().toString().trim());
                                SpUtil.putString(LoginActivity.this, "passWord", password.getText().toString().trim());
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
                            //loadingDialog.close();
                        }
                    });
        }
    }

    /**
     * 获取字典数据
     */
    private void getDictionary(final int offSet) {
        if (!NetUtil.isConnected(this)){
            ToastUtil.showShort(this, "网连接未连接");
        }else {
            Observable.just(offSet).flatMap(new Function<Integer, ObservableSource<List<Dictionary>>>() {
                @Override
                public ObservableSource<List<Dictionary>> apply(@NonNull Integer integer) throws Exception {
                    return RetrofitHttp.getRetrofit().getDictionary(integer);
                }
            }).subscribeOn(Schedulers.io()).subscribe(new Consumer<List<Dictionary>>() {
                @Override
                public void accept(@NonNull List<Dictionary> dictionaries) throws Exception {
                    if (null != dictionaries && dictionaries.size() > 0){
                        for (Dictionary dictionary : dictionaries) {
                            dictionaryDao.insertOrReplace(dictionary);
                        }
                        if (dictionaries.size() == 50){
                            getDictionary(offSet+1);
                        }
                    }
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
            RetrofitHttp.getRetrofit().getAllUserInfo().subscribeOn(Schedulers.io()).subscribe(new Consumer<List<UserInfo>>() {
                @Override
                public void accept(@NonNull List<UserInfo> userInfos) throws Exception {

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
