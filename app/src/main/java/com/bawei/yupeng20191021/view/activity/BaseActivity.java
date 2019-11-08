package com.bawei.yupeng20191021.view.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.yupeng20191021.presenter.BasePresenter;
import com.bawei.yupeng20191021.view.inter.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P p;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p =setPresenter();
        p.attachView(this);
        initData();

}

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.dataView();
    }
}
