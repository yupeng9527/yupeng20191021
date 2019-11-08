package com.bawei.yupeng20191021.view.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yupeng20191021.Bean.OnnowBean;
import com.bawei.yupeng20191021.R;
import com.bawei.yupeng20191021.view.activity.DetailsActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class OnnowrecyAdpter extends RecyclerView.Adapter {
    private List<OnnowBean.ResultBean> result;
    private Context context;


    public OnnowrecyAdpter(List<OnnowBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onnowitem,null);
       ViewHolder viewHoler=new ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv.setText(result.get(i).name);
        String imageUrl = result.get(i).imageUrl;
        Glide.with(context).load(imageUrl).into(viewHolder1.img);
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int movieId = result.get(i).movieId;
               Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("movieId",movieId);
                context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return result.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
