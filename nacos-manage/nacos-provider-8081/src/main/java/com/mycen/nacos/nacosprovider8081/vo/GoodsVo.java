package com.mycen.nacos.nacosprovider8081.vo;

import com.mycen.nacos.nacosprovider8081.pojo.Goods;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVo {

    private Integer current;
    private Integer size;
    private Long total;
    private List<Goods> userList;

}
