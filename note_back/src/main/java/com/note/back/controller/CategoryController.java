/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryController
 * Author:   Administrator
 * Date:     2020/6/4 14:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.controller;

import com.note.back.pojo.Category;
import com.note.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4
 * @since 1.0.0
 */

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /*@CrossOrigin
    @ResponseBody
    @GetMapping("/api/categories")
    public List<Category> getAll(){
        List<Category> c =  categoryService.getAll();
        return c;
    }*/
}
