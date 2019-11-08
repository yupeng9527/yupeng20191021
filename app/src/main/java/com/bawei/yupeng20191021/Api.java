package com.bawei.yupeng20191021;


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

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Api {

    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LoginBean> getlogin(@FieldMap Map<String, String> map);

    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<LoginBean> getRegis(@FieldMap Map<String, String> map);

    //banner
    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean>getbanner();
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<OnnowBean>getfindHot(@Query("page") int page, @Query("count") int count);
    //即将上映
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<UpcomingBean> getfindcoming(@Query("page") int page, @Query("count") int count);
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HotmovieBean> getfindHot2(@Query("page") int page, @Query("count") int count);
    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas?page=1&count=10")
    Observable<TuijianBean> gettuijian();
    //推荐影院
    @GET("movieApi/cinema/v1/findNearbyCinemas?page=1&count=10")
    Observable<FujinBean> getfujin();

    //电影详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<DetailsBean>getDetails(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId);

    //电影评论
    @GET("movieApi/movie/v1/verify/movieComment")
    Observable<CommentsBean> getComments(@Query("movieId") int movieId,
                                         @Query("page") int page,
                                         @Query("count") int count);

    //添加影片评论
    @FormUrlEncoded
    @POST("movie1erify/movieComment")
    Observable<WriterreviewsBean> getWriter(@Header("userId") int userid,
                                            @Header("sessionId") String sessionId,
                                            @Field("movieId") int movieId,
                                            @Field("commentContent") String commentContent,
                                            @Field("score") double score
    );


}
