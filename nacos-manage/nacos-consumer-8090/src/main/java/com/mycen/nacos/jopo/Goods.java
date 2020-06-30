package com.mycen.nacos.jopo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Goods {

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
