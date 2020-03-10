package com.example.jkl.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FindUserInfo {

    private String username;

    private String password;

    @Column(name = "u_img")
    private String uImg;

    @Column(name = "nick_name")
    private String nickName;

    private Long phone;

    @Column(name = "last_money")
    private Double lastMoney;

}
