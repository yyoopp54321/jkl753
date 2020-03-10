package com.example.jkl.request;

import com.example.jkl.pojo.OrderEntity;
import lombok.Data;

import java.util.List;

@Data
public class PayOrderRequest {
   private List<OrderEntity> orderEntityList;
   private Double totalMoneys;
}
