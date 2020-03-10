package com.example.jkl.controller;

import com.example.jkl.adapter.WechatAdapter;
import com.example.jkl.dto.LoginDTO;
import com.example.jkl.dto.ResultDTO;
import com.example.jkl.dto.SessionDTO;
import com.example.jkl.dto.TokenDto;
import com.example.jkl.error.CommonErrorCode;
import com.example.jkl.error.ErrorCodeException;
import com.example.jkl.pojo.User;
import com.example.jkl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Slf4j
public class WxLoginController {
    @Autowired
    WechatAdapter wechatAdapter;
    @Autowired
    UserService userService;
    @GetMapping(value = "fing/user/by/openid")
    public ResultDTO findUserByOpenid(LoginDTO loginDTO){
        try {

            SessionDTO sessionDTO = wechatAdapter.jscode2session(loginDTO.getCode());


//            SessionDTO sessionDTO=new SessionDTO();
//            sessionDTO.setOpenid("asdfsdfsdf");

            String token = UUID.randomUUID().toString();
            User user = userService.findUserByOpenId(sessionDTO.getOpenid());
            if(user==null){
                user=new User();
            }
            user.setToken(token);
            user.setOpenId(sessionDTO.getOpenid());
            Integer integer = userService.saveOrUpdate(user);
            User user1 = userService.findUserByOpenId(sessionDTO.getOpenid());
            if(integer==1){
                //生成token，用于自定义登录态，这里的存储逻辑比较复杂，放到下一讲
                TokenDto data =new TokenDto();
                data.setToken(token);
                return ResultDTO.ok(data);
            }else {
                return ResultDTO.fail(CommonErrorCode.UNKOWN_ERROR);
            }

        } catch (ErrorCodeException e) {
            log.error("login error, info : {}", loginDTO, e.getMessage());
            return ResultDTO.fail(e);
        } catch (Exception e) {
            log.error("login error, info : {}", loginDTO, e);
            return ResultDTO.fail(CommonErrorCode.UNKOWN_ERROR);
        }
    }

}
