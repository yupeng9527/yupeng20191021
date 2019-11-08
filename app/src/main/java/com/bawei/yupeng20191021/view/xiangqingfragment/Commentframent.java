package com.bawei.yupeng20191021.view.xiangqingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bawei.yupeng20191021.Bean.CommentsBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.CommentPresenter;
import com.bawei.yupeng20191021.view.adapter.CommentAdapter;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Commentframent extends Fragment implements IMainView.comment {
    @BindView(R.id.critices_recy)
    RecyclerView criticesRecy;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_comment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        //得到movieid
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);

        CommentPresenter commentPresenter = new CommentPresenter();
        commentPresenter.attachView(this);
        commentPresenter.getcomment(movieId);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        criticesRecy.setLayoutManager(linearLayoutManager);
        return inflate;
    }


    public void comment(CommentsBean bean) {
        List<CommentsBean.ResultBean> result = bean.getResult();
        CommentAdapter comment_adapter = new CommentAdapter(R.layout.commentsitem, result);
        criticesRecy.setAdapter(comment_adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        criticesRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
