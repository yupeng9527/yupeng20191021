package com.bawei.yupeng20191021.presenter;


import android.util.Log;

import com.bawei.yupeng20191021.Bean.BannerBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class BannerPresenter extends BasePresenter<IMainView.banner> {
   public void getbanner(){
       OkHttp.getInstance().bannergetdata(new OkHttp.CallBack<BannerBean>() {
           @Override
           public void ok(BannerBean o) {
               Log.i("bbbbbb", "ok: "+o.message);
               getView().banner(o);
           }
       });
   }
}
