package com.example.jkl.response;

import lombok.Data;

import java.util.Date;

@Data
public class FindAllGoodsResponse {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer stock;
    private Double price;
    private String gAddress;
    private Date createTime;

}
