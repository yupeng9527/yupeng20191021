package com.bawei.yupeng20191021.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.DetailsPresenter;
import com.bawei.yupeng20191021.view.adapter.NoticeAdapter;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public  class Noticeframent extends Fragment implements IMainView.detail {
    @BindView(R.id.sp)
    RecyclerView sp;
    Unbinder unbinder;
    private String sessionId;
    private SharedPreferences aa;
    private int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_notice, container, false);
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


    public void detail(DetailsBean detailsBean) {
        List<DetailsBean.ResultBean.ShortFilmListBean> shortFilmList = detailsBean.result.shortFilmList;
        NoticeAdapter noticeAdapter = new NoticeAdapter(shortFilmList, getContext());
        sp.setAdapter(noticeAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        sp.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ok(DetailsBean detailsBean) {

    }

    @Override
    public void no(String msg) {

    }
}
