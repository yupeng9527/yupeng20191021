package com.bawei.yupeng20191021.view.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.DetailsPresenter;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public  class Introduceframent extends Fragment implements IMainView.detail {
    @BindView(R.id.tv_introduce_summary)
    TextView tvIntroduceSummary;
    @BindView(R.id.recycler_introduce_movieDirector)
    RecyclerView recyclerIntroduceMovieDirector;
    @BindView(R.id.recycler_introduce_movieActor)
    RecyclerView recyclerIntroduceMovieActor;
    Unbinder unbinder;

    private String sessionId;
    private SharedPreferences aa;
    private int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_introduce, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        //取出存入sp的userId和sessionId
        aa = getActivity().getSharedPreferences("aa", Context.MODE_PRIVATE);
        userId = aa.getInt("userId", 1);
        sessionId = aa.getString("sessionId", "");

        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        DetailsPresenter detailsPresenter = new DetailsPresenter();
        detailsPresenter.attachView(this);
        detailsPresenter.getdetail(userId,sessionId,movieId);
        //导演布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerIntroduceMovieDirector.setLayoutManager(linearLayoutManager);
        //演员布局管理器
        GridLayoutManager linearLayoutManager1=new GridLayoutManager(getContext(),5);
        recyclerIntroduceMovieActor.setLayoutManager(linearLayoutManager1);
        return inflate;
    }

    public void detail(DetailsBean detailsBean) {
       Log.e("","aa"+detailsBean.result);
        DetailsBean.ResultBean result = detailsBean.result;
        tvIntroduceSummary.setText(result.summary);
        //导演
        List<DetailsBean.ResultBean.MovieDirectorBean> movieDirector = detailsBean.result.movieDirector;
        Log.i("asd", "succ: " + movieDirector.size());
        IntroduceFragmentAdapter adapter = new IntroduceFragmentAdapter(R.layout.introduce_adapter, movieDirector);
        recyclerIntroduceMovieDirector.setAdapter(adapter);
        //演员
        List<DetailsBean.ResultBean.MovieActorBean> movieActor = detailsBean.result.movieActor;
        IntroduceFragmentAdapteryanyuan yanyuan = new IntroduceFragmentAdapteryanyuan(R.layout.introduce_yanyuan, movieActor);
        recyclerIntroduceMovieActor.setAdapter(yanyuan);
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
