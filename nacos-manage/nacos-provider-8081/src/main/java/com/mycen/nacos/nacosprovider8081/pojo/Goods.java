package com.mycen.nacos.nacosprovider8081.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_item")
public class Goods {
    @TableId(value = "id" ,type = IdType.AUTO)
    private String id;
    private String title;
    private String sell_point;
    private Double  price;
    private Integer num;
    private String barcode;
    private String image;
    private Integer cid;
    private Integer status;


}
