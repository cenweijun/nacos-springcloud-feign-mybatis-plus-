package com.mycen.nacos.nacosprovider8081.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycen.nacos.nacosprovider8081.common.ServerResponse;
import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import com.mycen.nacos.nacosprovider8081.vo.GoodsVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService {

    //商品下架
    ServerResponse<String > downShelves(String id);


    //商品上架
    ServerResponse<String > putShelves(String id);

    //商品上传
    ServerResponse<String >  insertGoods(Goods goods);

    //商品修改
    ServerResponse<String> updataGoods(Goods goods );


    //分页查询
    ServerResponse<GoodsVo> QueryByPage(int pageNo, int pageSize);

    //删除
    ServerResponse<String > deleteById(String  id);


}
