package com.sky.coffee.service;
import com.sky.coffee.dto.UserInfoDTO;
import com.sky.coffee.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICacheService {
    UserInfo getUserInfo(HttpServletRequest request);

    void setLoginUserInfo(String key, HttpServletRequest request, UserInfo info);

    void outLogin(String sessionId);



    void setLoginUserInfo(HttpServletRequest request, UserInfoDTO info);

}
