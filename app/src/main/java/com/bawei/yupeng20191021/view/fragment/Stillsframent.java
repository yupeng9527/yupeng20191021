package com.bawei.yupeng20191021.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.DetailsPresenter;
import com.bawei.yupeng20191021.view.adapter.StillsAdapter;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:刘阳
 *@Date: 2019年
 *@Time:
 *@Description:
 * */public class Stillsframent extends Fragment implements IMainView.detail {
    @BindView(R.id.jz)
    RecyclerView jz;
    Unbinder unbinder;
    private String sessionId;
    private SharedPreferences aa;
    private int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_still, container, false);
        aa = getActivity().getSharedPreferences("aa", Context.MODE_PRIVATE);
        userId = aa.getInt("userId", 1);
        sessionId = aa.getString("sessionId", "");
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        DetailsPresenter detailsPresenter = new DetailsPresenter();
        detailsPresenter.getdetail(userId, sessionId, movieId);
        detailsPresenter.attachView(this);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ok(DetailsBean detailsBean) {
        List<String> posterList = detailsBean.result.posterList;
        StillsAdapter stillsAdapter = new StillsAdapter(posterList, getContext());
        jz.setAdapter(stillsAdapter);
        GridLayoutManager linearLayoutManager1=new GridLayoutManager(getContext(),5);
        jz.setLayoutManager(linearLayoutManager1);
    }

    @Override
    public void no(String msg) {

    }
}
