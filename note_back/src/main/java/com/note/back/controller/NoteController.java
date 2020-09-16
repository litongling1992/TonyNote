/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: NoteController
 * Author:   Administrator
 * Date:     2020/6/4 18:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.note.back.controller;

import com.note.back.pojo.Category;
import com.note.back.pojo.Note;
import com.note.back.response.Response;
import com.note.back.service.CategoryService;
import com.note.back.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
public class NoteController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    NoteService noteService;

    @CrossOrigin
    @GetMapping("/api/categories")
    @ResponseBody
    public List<Category> getCategoryList(){
       // org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
       // return categoryService.getAllByUser((User)subject.getPrincipal());
        List<Category> categories = categoryService.getAll();
        return categories;
    }

    @CrossOrigin
    @GetMapping("/api/categories/{id}/notes")
    @ResponseBody
    public List<Note> getNotesById(@PathVariable("id") int id){
        //List<Note> category = noteService.getNoteByCategory(id);
      return noteService.getNoteByCategory(id);
    }

    @CrossOrigin
    @PostMapping("/api/update/note/{id}/info")
    @ResponseBody
    public Response updateNoteInfo(@RequestBody Note requestNote, @PathVariable("id") int id){
        Note note = noteService.getById(id);
        note.setName(requestNote.getName());
        note.setAbs(requestNote.getAbs());
        note.setLastmodifedTime(new Timestamp(System.currentTimeMillis()));
        noteService.updateNoteInfo(note);
        return new Response(200,"更新成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/update/category/{id}/note/add")
    @ResponseBody
    public Response addNote(@RequestBody Note requestNote,@PathVariable("id") int id){
        Note note = new Note();
        note.setName(requestNote.getName());
        note.setAbs(requestNote.getAbs());

        Category category = categoryService.getById(id);
        note.setCategory(category);

        note.setLastmodifedTime(new Timestamp(System.currentTimeMillis()));
        note.setCreateTime(new Timestamp(System.currentTimeMillis()));
        noteService.updateNoteInfo(note);
        return new Response(200,"添加成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/category/delete/{id}")
    @ResponseBody
    public Response deleteCategory(@PathVariable("id") int id){
        categoryService.deleteById(id);
        return new Response(200,"删除成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/note/delete/{id}")
    @ResponseBody
    public Response deleteNote(@PathVariable("id") int id){
        noteService.deleteById(id);
        return new Response(200,"删除成功",null);
    }

   /* @CrossOrigin
    @GetMapping("/api/category/delete/{id}")
    @ResponseBody
    public Response deleteCategory(@PathVariable("id") int id){
        categoryService.deleteById(id);
        return new Response(200,"成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/category/add")
    @ResponseBody
    public Response addCategory(@RequestBody Category requestCategory){

        Subject subject = SecurityUtils.getSubject();
        Category category = new Category();
        category.setName(requestCategory.getName());
        category.setAuthor((User)subject.getPrincipal());
        categoryService.updateGory(category);
        return new Response(200,"成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/category/update")
    @ResponseBody
    public Response updateCategory(@RequestBody Category requestCategory){
        Category category = categoryService.getById(requestCategory.getId());
        category.setName(requestCategory.getName());
        categoryService.updateGory(category);
        return new Response(200,"成功",null);
    }


    @CrossOrigin
    @GetMapping("/api/notes")
    @ResponseBody
    public List<Note> getNoteList(){
        return noteService.getAll();
    }


    @CrossOrigin
    @GetMapping("/api/note/{id}")
    @ResponseBody
    public Response getNote(@PathVariable("id") int id){
        Note note = noteService.getById(id);
        return new Response(200,"成功",note);
    }


    @CrossOrigin
    @GetMapping("/api/note/delete/{id}")
    @ResponseBody
    public Response deleteNote(@PathVariable("id") int id){
        noteService.deleteById(id);
        return new Response(200,"成功",null);
    }

    @CrossOrigin
    @GetMapping("/api/categories/{id}/notes")
    @ResponseBody
    public List<Note> getNotesByCategory(@PathVariable("id") int id){
        return noteService.getNoteByCategory(id);
    }

    @CrossOrigin
    @PostMapping("/api/update/{type}/note/{id}")
    @ResponseBody
    public Response updateNoteInfo(@RequestBody Note requestNote, @PathVariable("id") int id,@PathVariable("type") String type){
        Note note = noteService.getById(id);
        if(type.equals("info")){
            note.setName(requestNote.getName());
            note.setAbs(requestNote.getAbs());
        }
        else if(type.equals("content")){
            note.setContentHtml(requestNote.getContentHtml());
            note.setContentMd(requestNote.getContentMd());
        }
        note.setLastmodifedTime(new Timestamp(System.currentTimeMillis()));
        noteService.updateNote(note);
        return new Response(200,"成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/update/category/{id}/note/add")
    @ResponseBody
    public Response addNote(@RequestBody Note requestNote,@PathVariable("id") int id){
        Subject subject = SecurityUtils.getSubject();
        Note note = new Note();
        note.setName(requestNote.getName());
        note.setAbs(requestNote.getAbs());
        Category category = categoryService.getById(id);
        note.setCategory(category);
        note.setCreateTime(new Timestamp(System.currentTimeMillis()));
        note.setLastmodifedTime(new Timestamp(System.currentTimeMillis()));
        note.setAuthor((User)subject.getPrincipal());
        noteService.updateNote(note);
        return new Response(200,"成功",null);
    }


    final static String PIC_PATH = "static/pics/";

    @CrossOrigin
    @PostMapping("/api/pic")
    @ResponseBody
    public Response uploadPic(MultipartHttpServletRequest multiRequest, HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src/main/resources/"+PIC_PATH;

        File folder = new File(savePath+datePrefix);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String originalName = multiRequest.getFile("image").getOriginalFilename();
        String saveName = UUID.randomUUID().toString() + originalName.substring(originalName.lastIndexOf("."),originalName.length());
        String absolutePath = folder.getAbsolutePath();

        try{
            File fileToSave = new File(absolutePath + File.separator + saveName);
            multiRequest.getFile("image").transferTo(fileToSave);
            String returnPath = request.getScheme() + "://"
                    + request.getServerName()+":"+request.getServerPort()
                    +"/article/images/"
                    + datePrefix +"/"+ saveName;

            return new Response(200,"上传成功",returnPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response(500,"上传失败",null);

    }*/


}
