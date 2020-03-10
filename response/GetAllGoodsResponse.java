package com.example.jkl.response;

import lombok.Data;

import java.util.List;

@Data
public class GetAllGoodsResponse {
    List<FindGoodsResponse> findGoodsResponseList;
    Long total;
}
