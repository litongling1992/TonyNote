/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: NoteService
 * Author:   Administrator
 * Date:     2020/6/4 18:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.service;

import com.note.back.dao.CategoryDao;
import com.note.back.dao.NoteDao;
import com.note.back.pojo.Category;
import com.note.back.pojo.Note;
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
public class NoteService {

    @Autowired
    NoteDao noteDao;

    @Autowired
    CategoryDao categoryDao;

    public List<Note> getAll(){
        return noteDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public List<Note> getNoteByCategory(int id){
        Category category = categoryDao.getOne(id);
        return noteDao.findAllByCategory(category);
    }

    /*public Note getById(int id){
        return noteDao.findById(id).get();
    }

    public void deleteById(int id) {
        noteDao.deleteById(id);
    }

    public void updateNote(Note note){
        noteDao.save(note);
    }*/
}
