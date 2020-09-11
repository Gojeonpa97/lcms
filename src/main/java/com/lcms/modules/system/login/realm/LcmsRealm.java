package com.lcms.modules.system.login.realm;

import com.lcms.modules.system.user.domain.entity.UserEntity;
import com.lcms.modules.system.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class LcmsRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 用户授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserEntity user = userService.findUserByName(token.getUsername());
        if(null == user){
            return null;
        }
        if("1".equals(user.getStatus())){
            throw new DisabledAccountException("账号已禁用");
        }
        if("1".equals(user.getDelFlag())){
            throw new DisabledAccountException("账号已删除");
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword().toCharArray(),getName());
        return simpleAuthenticationInfo;
    }
}
