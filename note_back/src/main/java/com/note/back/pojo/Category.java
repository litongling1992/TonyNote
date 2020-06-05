/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Category
 * Author:   Administrator
 * Date:     2020/6/4 14:28
 * Description: 目录表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈目录表〉
 *
 * @author Administrator
 * @create 2020/6/4
 * @since 1.0.0
 */

@Entity
@Table(name = "Category")
@JsonIgnoreProperties({"handle" , "hibernateLazyInitializer"})
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;


   /* @ManyToOne
    @JoinColumn(name="author")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }*/

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
