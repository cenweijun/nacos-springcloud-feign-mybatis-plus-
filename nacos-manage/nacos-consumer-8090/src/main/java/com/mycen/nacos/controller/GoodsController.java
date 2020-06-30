package com.mycen.nacos.controller;

import com.mycen.nacos.client.Client;
import com.mycen.nacos.common.ServerResponse;
import com.mycen.nacos.jopo.Goods;
import com.mycen.nacos.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/goods/")
@CrossOrigin
public class GoodsController {

    @Autowired
    private Client client;


    //下架
    @RequestMapping("downShelves")
    public ServerResponse<String > downShelves(String id){
        return client.downShelves(id);
    }


    //上架
    @RequestMapping("putShevles")
    public ServerResponse<String > putShevles(String id){
        return client.putShelves(id);
    }


//    //修改
//    @RequestMapping("updateGoods")
//    public ServerResponse<String> updateGoods(Goods goods, MultipartFile file){
//        return client.updateGoods(goods,file);
//
//    }


    //添加或者修改
    @PostMapping("insertOrUpdateGoods")
    public ServerResponse<String>  insertGoods(@RequestBody Goods goods){
        return  client.insertGoods(goods);
    }


    //删除
    @RequestMapping("deleteById")
    public ServerResponse<String> deleteById(String id){
     return client.deleteById(id);
    }

    //分页查询
    @RequestMapping("queryByPage")
    ServerResponse<GoodsVo> queryByPage(@RequestParam(value = "pageNo", defaultValue = "1")Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize){
        return client.queryByPage(pageNo,pageSize);
    }
}
