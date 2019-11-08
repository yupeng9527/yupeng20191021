package com.bawei.yupeng20191021.presenter;


import com.bawei.yupeng20191021.Bean.CommentsBean;
import com.bawei.yupeng20191021.OkHttp;
import com.bawei.yupeng20191021.view.inter.IMainView;

public class CommentPresenter extends BasePresenter<IMainView.comment>  {

    public void getcomment(int movieId) {
        OkHttp.getInstance().commentdata(movieId, new OkHttp.CallBack<CommentsBean>() {
            @Override
            public void ok(CommentsBean bean) {
                getView().ok(bean);
            }
        });
    }

}
