package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.HotmovieBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class Hotmoviespresenter extends BasePresenter<IMainView.recyview3>{

    public void getrecyview3() {
        OkHttp.getInstance().RecygetData3(new OkHttp.CallBack<HotmovieBean>() {
            @Override
            public void ok(HotmovieBean bean) {
                getView().recyview3(bean);
            }
        });
    }
}
