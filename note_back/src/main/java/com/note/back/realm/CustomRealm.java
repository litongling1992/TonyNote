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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.protocol.http.AuthenticationInfo;

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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        String userName = authenticationToken.getPrincipal().toString();
        User user =userService.getUserByUsername(userName);

        String password = user.getPassword();
        String salt =user.getSalt();
        SimpleAuthenticationInfo simpleAuthenticationInfo=new
                SimpleAuthenticationInfo(user,password,ByteSource.Util.bytes
                (salt),getName());
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthorizationInfo(PrincipalCollection
                                                     principalCollection)
    {
        return null;
    }
}
