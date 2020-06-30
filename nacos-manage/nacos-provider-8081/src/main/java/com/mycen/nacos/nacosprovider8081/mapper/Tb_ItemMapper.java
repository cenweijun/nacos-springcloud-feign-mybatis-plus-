package com.mycen.nacos.nacosprovider8081.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("tbItemMapper")
public interface Tb_ItemMapper extends BaseMapper<Goods> {

}
