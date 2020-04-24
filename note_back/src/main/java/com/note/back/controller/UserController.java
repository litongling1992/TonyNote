/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2020/4/23 11:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.controller;

import com.note.back.pojo.User;
import com.note.back.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/23
 * @since 1.0.0
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public String register(@RequestBody User user){
        String username = user.getUsername();
        username=HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        String password = user.getPassword();

        boolean isExit = userService.isExit(username);
        if (isExit){
            return "用户名已存在";
        }
        String salt =new SecureRandomNumberGenerator().nextBytes().toString();
        int times =2;
        String algorithm = "md5";
        String pwdAfterHash = new SimpleHash(algorithm,password,salt,times)
                .toString();
        user.setSalt(salt);
        user.setPassword(pwdAfterHash);
        userService.addUser(user);
        return "注册成功";
    }

}
