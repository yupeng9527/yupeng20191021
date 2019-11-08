package com.bawei.yupeng20191021.view.activity;


import com.bawei.yupeng20191021.Bean.DetailsBean;

public class EvenBus_XuanZuo {
    private DetailsBean xuanzuo;

    public EvenBus_XuanZuo(DetailsBean xuanzuo) {
        this.xuanzuo = xuanzuo;
    }

    @Override
    public String toString() {
        return "EvenBus_XuanZuo{" +
                "xuanzuo=" + xuanzuo +
                '}';
    }

    public DetailsBean getXuanzuo() {
        return xuanzuo;
    }

    public void setXuanzuo(DetailsBean xuanzuo) {
        this.xuanzuo = xuanzuo;
    }
}
