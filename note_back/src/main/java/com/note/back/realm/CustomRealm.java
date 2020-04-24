/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomRealm
 * Author:   Administrator
 * Date:     2020/4/23 17:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.realm;

import com.note.back.pojo.User;
import com.note.back.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;





/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/23
 * @since 1.0.0
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected org.apache.shiro.authc.AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        //token是用户输入的
        //第一步:从token里面取出用户的身份信息
        String userName = token.getPrincipal().toString();

        //第二步:拿着用户输入的userCode从数据库中查询是否存在该用户
        //...数据库
        /*模拟从数据库查询到密码,
         * 这里是已经根据用户输入的账号在数据库查了，
         * 已经是查得有该账户的存在，并将密码也查询出来了，
         * 111就是该账户的密码
         */
        User user =userService.getUserByUsername(userName);
        String password = user.getPassword();
        String salt =user.getSalt();

        //如果查询不到返回null
        //如果查询到返回认证信息AuthenticationInfo，AuthenticationInfo是一个接口
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,password, ByteSource.Util.bytes(salt),this.getName());
        return simpleAuthenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
                                                     principalCollection)
    {
        return null;
    }
}
