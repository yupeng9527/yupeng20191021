package com.bawei.yupeng20191021.view.Fragmenttwo;


import com.bawei.yupeng20191021.Bean.TuijianBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.presenter.TuijianPresenter;
import com.bawei.yupeng20191021.view.fragment.BaseFragment;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class YinyuanThreeFragment  extends BaseFragment<TuijianPresenter> implements IMainView.ITui {

    @Override
    protected void initData() {

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
        return R.layout.fragment_yinyuan_three;
    }

    @Override
    public void ok(TuijianBean tuijianBean) {

    }

    @Override
    public void no(String msg) {

    }
}
