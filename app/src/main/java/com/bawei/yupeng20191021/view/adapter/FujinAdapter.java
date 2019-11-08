package com.bawei.yupeng20191021.view.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yupeng20191021.Bean.FujinBean;
import com.bawei.yupeng20191021.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@Auther:刘阳
 *@Date: 2019/10/22
 *@Description:功能
 **/public class FujinAdapter extends RecyclerView.Adapter {

     private Context context;
     private List<FujinBean.ResultBean> list;



    public FujinAdapter(Context context, List<FujinBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.fujin, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       ViewHolder viewHolder1 =(ViewHolder) viewHolder;
       viewHolder1.tv_fujin_one.setText(list.get(i).getName());
       viewHolder1.tv_fujin_three.setText(list.get(i).getAddress());
        Glide.with(context)
                .load(list.get(i).getLogo())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_fujin);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public void getfu(List<TuijianBean.ResultBean> data){
//        if (data!=null && data.size()>0){
//            list.addAll(data);
//        }
//    }



    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_fujin_one,tv_fujin_two,tv_fujin_three;
        ImageView iv_fujin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_fujin_one=itemView.findViewById(R.id.tv_fujin_one);
            tv_fujin_two=itemView.findViewById(R.id.tv_fujin_two);
            tv_fujin_three=itemView.findViewById(R.id.tv_fujin_three);
            iv_fujin=itemView.findViewById(R.id.iv_fujin);
        }
    }

}
