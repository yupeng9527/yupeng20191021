package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.TuijianBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class TuijianPresenter extends BasePresenter<IMainView.ITui>{
    public void setTuijian (){
        OkHttp.getInstance().getTuijian(new OkHttp.CallBack<TuijianBean>() {
            @Override
            public void ok(TuijianBean tuijianBean) {
                getView().ok(tuijianBean);
            }

        });
    }
}
