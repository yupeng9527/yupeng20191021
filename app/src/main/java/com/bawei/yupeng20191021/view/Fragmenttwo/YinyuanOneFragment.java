package com.bawei.yupeng20191021.view.Fragmenttwo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.bawei.yupeng20191021.Bean.TuijianBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.TuijianPresenter;
import com.bawei.yupeng20191021.view.adapter.ReTuijianAdapter;
import com.bawei.yupeng20191021.view.fragment.BaseFragment;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class YinyuanOneFragment extends BaseFragment<TuijianPresenter> implements IMainView.ITui {

    @BindView(R.id.re_tuijian)
    RecyclerView reTuijian;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private ReTuijianAdapter reTuijianAdapter;

    @Override
    protected void initData() {
        f.setTuijian();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        reTuijian.setLayoutManager(linearLayoutManager);
        reTuijianAdapter = new ReTuijianAdapter(getContext());
        reTuijian.setAdapter(reTuijianAdapter);
    }

    @Override
    protected TuijianPresenter setFrag() {
        return new TuijianPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yinyuan_one;
    }

    @Override
    public void ok(TuijianBean tuijianBean) {
        List<TuijianBean.ResultBean> result = tuijianBean.getResult();
        reTuijianAdapter.getTui(result);
        Toast.makeText(getActivity(), ""+tuijianBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void no(String msg) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
