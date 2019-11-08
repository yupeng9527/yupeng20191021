package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class DetailsPresenter extends BasePresenter<IMainView.detail> {
    public void getdetail(int userId, String sessionId, int movieId) {
        OkHttp.getInstance().datailsgetdata(userId, sessionId, movieId, new OkHttp.CallBack<DetailsBean>() {
            @Override
            public void ok(DetailsBean bean) {
                getView().ok(bean);
            }
        });
    }
}
