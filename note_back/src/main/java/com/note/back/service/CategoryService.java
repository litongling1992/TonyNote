/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryService
 * Author:   Administrator
 * Date:     2020/6/4 14:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.service;

import com.note.back.dao.CategoryDao;
import com.note.back.pojo.Category;
import com.note.back.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4
 * @since 1.0.0
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Category> getAll(){

        return categoryDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public Category getOneById(int id){

        return categoryDao.getOne(id);
    }


    /*public List<Category> getAllByUser(User author){

        return categoryDao.findByAuthor(author);

    }*/

    public Category getById(int id){

        return categoryDao.findById(id).get();
    }

    public void deleteById(int id){
        categoryDao.deleteById(id);
    }

    public void updateGory(Category category){
        categoryDao.save(category);
    }
}
