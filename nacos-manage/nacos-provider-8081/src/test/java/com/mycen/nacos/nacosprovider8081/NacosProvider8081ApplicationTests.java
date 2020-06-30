package com.mycen.nacos.nacosprovider8081;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycen.nacos.nacosprovider8081.mapper.Tb_ItemMapper;
import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import com.mycen.nacos.nacosprovider8081.serviceimpl.GoodsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NacosProvider8081ApplicationTests {
    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    void contextLoads() {
    }

    @Test
    public void TestBypage(){
        goodsService.QueryByPage(2,10);

    }


}
