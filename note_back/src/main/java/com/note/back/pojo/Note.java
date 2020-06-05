/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Note
 * Author:   Administrator
 * Date:     2020/6/4 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4
 * @since 1.0.0
 */

@Entity
@Table(name = "note")
@JsonIgnoreProperties({"handle" , "hibernateLazyInitializer"})
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;

    private String abs;

    @Column(name = "content_html")
    private String contentHtml;

    @Column(name = "content_md")
    private String contentMd;

    @Column(name = "created_time")
    private Timestamp createTime;

    @Column(name = "last_modified_time")
    private Timestamp lastmodifedTime;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

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

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastmodifedTime() {
        return lastmodifedTime;
    }

    public void setLastmodifedTime(Timestamp lastmodifedTime) {
        this.lastmodifedTime = lastmodifedTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
