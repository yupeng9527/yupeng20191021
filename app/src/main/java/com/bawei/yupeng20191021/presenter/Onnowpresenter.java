package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.OnnowBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class Onnowpresenter extends BasePresenter<IMainView.recyview>{

   public void getrecyview() {
       OkHttp.getInstance().RecygetData(new OkHttp.CallBack<OnnowBean>() {
           @Override
           public void ok(OnnowBean bean) {
               getView().recyview(bean);
           }
       });
   }
}
