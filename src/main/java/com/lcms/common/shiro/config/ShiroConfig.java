package com.lcms.common.shiro.config;

import com.lcms.modules.system.login.realm.LcmsRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
@Configuration
public class ShiroConfig {


    /**
     * 自定义realm
     * @return
     */
    @Bean
    public LcmsRealm lcmsRealm(){
        LcmsRealm lcmsRealm = new LcmsRealm();
        return lcmsRealm;
    }

    /**
     * 安全管理器
     * @param lcmsRealm
     * @return
     */
    @Bean
    public SecurityManager securityManager(LcmsRealm lcmsRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(lcmsRealm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl("/login");
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login" ,"anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/static/**","anon");
       // filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
