package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.LoginBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

import java.util.Map;

public class LoginPresenter extends BasePresenter<IMainView.login> {

    public void setlogin(Map<String,String> map){
        OkHttp.getInstance().getLogin(new OkHttp.CallBack<LoginBean>() {
            @Override
            public void ok(LoginBean o) {
                getView().ok(o);
            }
        },map);

    }

}
