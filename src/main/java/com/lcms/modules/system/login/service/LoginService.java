package com.lcms.modules.system.login.service;

import com.lcms.common.domain.dto.BaseResult;
import com.lcms.modules.system.login.domain.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

     BaseResult<Object> login(LoginVo loginVo, HttpServletRequest request);
}
