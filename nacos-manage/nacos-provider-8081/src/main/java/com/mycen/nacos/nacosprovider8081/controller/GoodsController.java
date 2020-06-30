package com.mycen.nacos.nacosprovider8081.controller;

import com.mycen.nacos.nacosprovider8081.common.ServerResponse;
import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import com.mycen.nacos.nacosprovider8081.service.GoodsService;
import com.mycen.nacos.nacosprovider8081.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/goods/")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    //下架
    @RequestMapping("downShelves")
    public ServerResponse<String > downShelves(String id){
        return  goodsService.downShelves(id);
    }


    //上架
    @RequestMapping("putShelves")
    public ServerResponse<String > putShelves(String id){
        return  goodsService.putShelves(id);
    }


//    //修改
//    @RequestMapping("updateGoods")
//    public ServerResponse<String> updateGoods(Goods goods,MultipartFile file){
//        return  goodsService.updataGoods(goods,file);
//    }


    //添加或修改
    @PostMapping("insertOrUpdateGoods")
    public ServerResponse<String>  insertGoods( @RequestBody Goods goods ){
        if(goods.getId()==null||"".equals(goods.getId())){
            return goodsService.insertGoods(goods);
        }
        return goodsService.updataGoods(goods);
    }



    //删除
    @RequestMapping("deleteById")
    public ServerResponse<String> deleteById(String id){
        return goodsService.deleteById(id);
    }


    //分页查询
    @RequestMapping("queryByPage")
    public ServerResponse<GoodsVo> queryByPage(@RequestParam(value = "pageNo", defaultValue = "1")Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize){

        return  goodsService.QueryByPage(pageNo,pageSize);
    }




}
