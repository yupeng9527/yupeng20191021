package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.UpcomingBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class Upcomingpresenter extends BasePresenter<IMainView.recyview2>{

    public void getrecyview2(int userId, String sessionId) {
        OkHttp.getInstance().RecygetData2(new OkHttp.CallBack<UpcomingBean>() {
            @Override
            public void ok(UpcomingBean bean) {
                getView().recyview2(bean);
            }
        });
    }
}
