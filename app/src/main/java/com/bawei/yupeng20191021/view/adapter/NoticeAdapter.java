package com.bawei.yupeng20191021.view.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yupeng20191021.Bean.DetailsBean;
import com.bawei.yupeng20191021.R;
import com.bumptech.glide.Glide;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.Holder> {
    private List<DetailsBean.ResultBean.ShortFilmListBean> list;
    private Context context;
    private Holder holder;

    public NoticeAdapter(List<DetailsBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.noticeadpter, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.jvc.setUp(list.get(i).videoUrl,list.get(i).imageUrl);
        Glide.with(context).load(list.get(i).imageUrl).into(holder.jvc.ivThumb);
    }

    public void initview() {
        holder.jvc.releaseAllVideos();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private JCVideoPlayer jvc;
        public Holder(@NonNull View itemView) {
            super(itemView);
            jvc = itemView.findViewById(R.id.shipin);
        }
    }
}
