package cn.ucai.fulicenter.data.net;

import android.content.Context;

import cn.ucai.fulicenter.data.bean.BoutiqueBean;
import cn.ucai.fulicenter.data.bean.CategoryChildBean;
import cn.ucai.fulicenter.data.bean.CategoryGroupBean;
import cn.ucai.fulicenter.data.bean.GoodsDetailsBean;
import cn.ucai.fulicenter.data.bean.NewGoodsBean;

/**
 * Created by clawpo on 2017/5/4.
 */

public interface IGoodsModel {
    void loadNewGoodsData(Context context,int catId, int pageId, int pageSize,
                          OnCompleteListener<NewGoodsBean[]> listener);
    void loadBoutiqueData(Context context, OnCompleteListener<BoutiqueBean[]> listener);

    void loadGoodsDetail(Context context, int goodsId, OnCompleteListener<GoodsDetailsBean> listener);

    void loadCreategoryGorup(Context context, OnCompleteListener<CategoryGroupBean[]> listener);
    void loadCreategoryChild(Context context,int parentId, OnCompleteListener<CategoryChildBean[]> listener);
}
