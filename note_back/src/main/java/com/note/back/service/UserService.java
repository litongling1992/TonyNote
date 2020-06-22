/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/4/23 11:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.service;

import com.note.back.dao.UserDao;
import com.note.back.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/23
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;



    public User getUserByUsername(String username){
        return userDao.findByUsername(username);
    }

    public boolean isExit(String username){

        User user = getUserByUsername(username);

        if (user!=null){
            return true;
        }
        return false;
    }

    public void addUser(User user){

        userDao.save(user);
    }
}
