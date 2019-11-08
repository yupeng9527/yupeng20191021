package com.bawei.yupeng20191021.view.inter;


import com.bawei.yupeng20191021.Bean.BannerBean;
import com.bawei.yupeng20191021.Bean.CommentsBean;
import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.Bean.FujinBean;
import com.bawei.yupeng20191021.Bean.HotmovieBean;
import com.bawei.yupeng20191021.Bean.LoginBean;
import com.bawei.yupeng20191021.Bean.OnnowBean;
import com.bawei.yupeng20191021.Bean.TuijianBean;
import com.bawei.yupeng20191021.Bean.UpcomingBean;
import com.bawei.yupeng20191021.Bean.WriterreviewsBean;

public interface IMainView {

    interface login extends IBaseView{
        void ok(LoginBean loginBean);
    }
    interface banner extends IBaseView{
        void banner(BannerBean bannerBean);
    }
    interface recyview extends IBaseView{
        void recyview(OnnowBean onnowBean);
    }
    interface recyview2 extends IBaseView{
        void recyview2(UpcomingBean upcomingBean);
    }
    interface recyview3 extends IBaseView{
        void recyview3(HotmovieBean hotmovieBean);
    }
    interface ITui extends IBaseView{
        void ok(TuijianBean tuijianBean);
        void no(String msg);
    }
    interface IFujin extends IBaseView{
        void ok(FujinBean fujinBean);
        void no(String msg);
    }
    interface detail extends IBaseView{
        void ok(DetailsBean detailsBean);
        void no(String msg);
    }
    interface comment extends IBaseView{
        void ok(CommentsBean commentsBean);
        void no(String msg);
    }
    interface writerReviews extends IBaseView{
        void ok(WriterreviewsBean writerreviewsBean);
        void no(String msg);
    }
    interface writerReviewspresenter extends IBaseView{
        void ok(WriterreviewsBean writerreviewsBean);
        void no(String msg);
    }
}
