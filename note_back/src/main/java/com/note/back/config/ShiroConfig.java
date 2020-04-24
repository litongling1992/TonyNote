package com.note.back.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Package com.note.back.config
 * Author 李同灵
 * date 2020/4/24 21:22
 */


@Configuration
public class ShiroConfig {

//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        return shiroFilterFactoryBean;
//    }
//@Bean
//public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
//    //这里设置了自己的过滤器
//    ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//    shiroFilter.setSecurityManager(securityManager);
//    //shiroFilter.setLoginUrl("/login");
//    //shiroFilter.setUnauthorizedUrl("/403.html");
//    return shiroFilter;
//}


//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(getRealm());
//        return securityManager;
//    }
//
//    @Bean
//    public CustomRealm getRealm(){
//        CustomRealm realm =new CustomRealm();
//        realm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return realm;
//    }
//
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        matcher.setHashAlgorithmName("md5");
//        matcher.setHashIterations(2);
//        return matcher;
//    }
}
