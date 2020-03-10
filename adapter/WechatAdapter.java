package com.example.jkl.adapter;

import com.example.jkl.dto.SessionDTO;
import com.example.jkl.error.CommonErrorCode;
import com.example.jkl.error.ErrorCodeException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WechatAdapter {

    private  static String appid="wx37c1e8b4dd2c72c4";

    private  static String secret="6951bb550583f4628b7df2a54a157c63";



    public SessionDTO jscode2session(String code) {
        String params = "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        Map map = new HashMap();
        try {
            // 解析相应内容（转换成json对象）
            JSONObject json = new JSONObject(sr);
            // 获取会话密钥（session_key）

            String session_key = json.get("session_key").toString();
            // 用户的唯一标识（openid）
            String openid = (String) json.get("openid").toString();

            map.put( "session_key",session_key);
            map.put( "openId",openid );
            SessionDTO sessionDTO=new SessionDTO();
            sessionDTO.setOpenid(openid);
            sessionDTO.setSessionKey(session_key);
            return sessionDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorCodeException(CommonErrorCode.OBTAIN_OPENID_ERROR);
        }
    }


}
