package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.FujinBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

/*
 *@Auther:刘阳
 *@Date: 2019/10/22
 *@Description:功能
 **/public class FujinPresenter extends BasePresenter<IMainView.IFujin> {
     public void setFujin(){
         OkHttp.getInstance().getFujin(new OkHttp.CallBack<FujinBean>() {
             @Override
             public void ok(FujinBean o) {
                 getView().ok(o);
             }
         });
     }

}
