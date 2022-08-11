package com.sky.coffee.service;
import com.sky.coffee.dto.UserInfoDTO;
import com.sky.coffee.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICacheService {
    UserInfo getUserInfo(HttpServletRequest request);

    void outLogin(String sessionId);

    String getCookie(final HttpServletRequest request);

    void setLoginUserInfo(HttpServletRequest request, UserInfoDTO info);

}
