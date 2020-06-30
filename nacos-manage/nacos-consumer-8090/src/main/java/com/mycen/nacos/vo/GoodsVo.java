package com.mycen.nacos.vo;


import com.mycen.nacos.jopo.Goods;
import lombok.Data;

import java.util.List;


@Data
public class GoodsVo {

    private Integer current;
    private Integer size;
    private Long total;
    private List<Goods> userList;

}
