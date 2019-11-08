package com.bawei.yupeng20191021.view.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yupeng20191021.Bean.TuijianBean;
import com.bawei.yupeng20191021.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ReTuijianAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<TuijianBean.ResultBean> listtui = new ArrayList<>();

    public ReTuijianAdapter(Context context) {
        this.context = context;
        this.listtui = listtui;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.retuijian, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_tuijian_one.setText(listtui.get(i).getName());
        viewHolder1.tv_tuijian_three.setText(listtui.get(i).getAddress());
        Glide.with(context)
                .load(listtui.get(i).getLogo())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_tuijian);
    }

    @Override
    public int getItemCount() {
        return listtui.size();
    }

    public void getTui(List<TuijianBean.ResultBean> result) {
        if (result!=null&&result.size()>0){
            listtui.addAll(result);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tuijian_one,tv_tuijian_two,tv_tuijian_three;
        ImageView iv_tuijian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tuijian_one=itemView.findViewById(R.id.tv_tuijian_one);
            tv_tuijian_two=itemView.findViewById(R.id.tv_tuijian_two);
            tv_tuijian_three=itemView.findViewById(R.id.tv_tuijian_three);
            iv_tuijian=itemView.findViewById(R.id.iv_tuijian);

        }
    }


}
