package com.mycen.nacos.client;

import com.mycen.nacos.common.ServerResponse;
import com.mycen.nacos.jopo.Goods;
import com.mycen.nacos.vo.GoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "nacos-provider")
public interface Client {
    @GetMapping("service")
    public String service();


    //文件上传
    @PostMapping ("/file/upload")
    String upload(@RequestParam("file") MultipartFile file);


    //下架
    @RequestMapping("/goods/downShelves")
    public ServerResponse<String > downShelves(@RequestParam String id);


    //上架
    @RequestMapping("/goods/putShelves")
    public ServerResponse<String > putShelves(@RequestParam String id);


//    //修改
//    @RequestMapping("updateGoods")
//    public ServerResponse<String> updateGoods(Goods goods,MultipartFile file);


    //添加或修改
    @PostMapping("/goods/insertOrUpdateGoods")
    public ServerResponse<String>  insertGoods(@RequestBody Goods goods);

    //删除
    @RequestMapping("/goods/deleteById")
    public ServerResponse<String> deleteById(@RequestParam("id")String id);

    //分页查询
    @RequestMapping("/goods/queryByPage")
    ServerResponse<GoodsVo> queryByPage(@RequestParam(value = "pageNo", defaultValue = "1")Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize);



}
