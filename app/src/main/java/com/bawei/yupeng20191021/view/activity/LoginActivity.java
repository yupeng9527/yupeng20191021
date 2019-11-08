package com.bawei.yupeng20191021.view.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yupeng20191021.Bean.LoginBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.LoginPresenter;
import com.bawei.yupeng20191021.utils.EncryptUtil;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements IMainView.login {

    @BindView(R.id.ed_login)
    EditText edLogin;
    @BindView(R.id.but_wang)
    Button butWang;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.tv_zhu)
    TextView tvZhu;
    @BindView(R.id.but_deng)
    Button butDeng;
    @BindView(R.id.tv_disan)
    TextView tvDisan;
    @BindView(R.id.iv_wei)
    ImageView ivWei;
    @BindView(R.id.ed_mima)
    EditText edMima;

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {
        ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.but_wang, R.id.tv_zhu, R.id.but_deng})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_wang:
                break;
            case R.id.tv_zhu:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.but_deng:
                String login = edLogin.getText().toString().trim();
                String mima = edMima.getText().toString().trim();
                if (TextUtils.isEmpty(login) || TextUtils.isEmpty(mima)){
                    Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
                }else {
                    String mi = EncryptUtil.encrypt(mima);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("email", login);
                    map.put("pwd", mi);
                    p.setlogin(map);
                }
                break;

        }
    }

    @Override
    public void ok(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,FilmActivity.class));
        }else{
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
