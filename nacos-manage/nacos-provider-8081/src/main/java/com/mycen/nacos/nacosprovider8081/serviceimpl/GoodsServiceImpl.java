package com.mycen.nacos.nacosprovider8081.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycen.nacos.nacosprovider8081.common.ServerResponse;
import com.mycen.nacos.nacosprovider8081.mapper.Tb_ItemMapper;
import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import com.mycen.nacos.nacosprovider8081.service.GoodsService;
import com.mycen.nacos.nacosprovider8081.util.UploadFile;
import com.mycen.nacos.nacosprovider8081.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private Tb_ItemMapper tbItemMapper;
    @Autowired
    private UploadFile uploadFile;


    //下架
    @Override
    public ServerResponse<String> downShelves(String id) {
        Goods goods=tbItemMapper.selectById(id);
        if(goods.getStatus()==2){
            return ServerResponse.createBySuccessMessage("该商品已经下架");
        }else if(goods.getStatus()==3){
            return ServerResponse.createByErrorMessage("该商品已经删除");
        }else{
            goods.setStatus(2);
            int num=tbItemMapper.updateById(goods);
            if(num==1){
                return ServerResponse.createBySuccessMessage("下架成功");
            }
            return ServerResponse.createByErrorMessage("下架失败");
        }
    }

    //上架
    @Override
    public ServerResponse<String> putShelves(String id) {
        Goods goods=tbItemMapper.selectById(id);
        if(goods.getStatus()==1){
            return ServerResponse.createBySuccessMessage("该商品已经上架");
        }else if(goods.getStatus()==3){
            return ServerResponse.createByErrorMessage("该商品已经删除");
        }else{
            goods.setStatus(1);
            int num=tbItemMapper.updateById(goods);
            if(num==1){
                return ServerResponse.createBySuccessMessage("上架成功");
            }
            return ServerResponse.createByErrorMessage("上传失败");
        }


    }




    //修改商品
    @Override
    public ServerResponse<String> updataGoods(Goods goods) {

        int num=tbItemMapper.updateById(goods);
        if (num==1){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败！");
    }




    //添加Goods
    @Override
    public ServerResponse<String> insertGoods(Goods goods) {


        int num=tbItemMapper.insert(goods);
        if (num==1){
            return ServerResponse.createBySuccessMessage("上传成功");
        }
        return ServerResponse.createByErrorMessage("上传失败！");
    }




    //删除
    @Override
    public ServerResponse<String> deleteById(String id) {
        Goods goods=tbItemMapper.selectById(id);
        if(goods.getStatus()==1){
            return  ServerResponse.createByErrorMessage("该商品正在销售中，请先将其下架再删除");
        }
        int num=tbItemMapper.deleteById(id);
        if(num==1){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败！");
    }




    //分页查询
    @Override
    public ServerResponse<GoodsVo> QueryByPage(int pageNo, int pageSize) {
        GoodsVo goodsVo = new GoodsVo();
        IPage<Goods> page = new Page<>(pageNo, pageSize);
        tbItemMapper.selectPage(page, null);
        goodsVo.setCurrent(pageNo);
        goodsVo.setSize(pageSize);
        goodsVo.setTotal(page.getTotal());
        goodsVo.setUserList(page.getRecords());
        return ServerResponse.createBySuccess(goodsVo);

    }


}
