package com.example.jkl.response;

import lombok.Data;

@Data
public class FindGoodsInfoResponse {
    private String name;
    private Integer storeId;
    private Integer stock;
    private Double price;
    private String brief;
    private String subImagesUrl;
}
