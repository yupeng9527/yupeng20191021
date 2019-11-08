package com.bawei.yupeng20191021.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yupeng20191021.presenter.BasePresenter;
import com.bawei.yupeng20191021.view.inter.IBaseView;


public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements IBaseView {

    public F f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLayout(), container, false);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        f = setFrag();
        f.attachView(this);
        initData();


    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setLayout();

    protected abstract F setFrag();

    public <T extends View> T getViewId(int id) {
        return getView().findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        f.dataView();
    }
}
