package com.example.jkl.request;

import com.example.jkl.pojo.Car;
import lombok.Data;

import java.util.List;

@Data
public class GetCarListResponse {
    private List<Car> carList;
    private Double totalMoney;
}
