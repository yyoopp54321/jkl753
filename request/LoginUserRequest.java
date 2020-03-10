package com.example.jkl.request;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class LoginUserRequest {
   private HttpServletRequest request;
   private String code;

}
