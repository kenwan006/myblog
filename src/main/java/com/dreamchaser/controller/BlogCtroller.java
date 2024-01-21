package com.dreamchaser.controller;

import com.dreamchaser.pojo.Blog;
import com.dreamchaser.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BlogCtroller {
    @Autowired
    BlogService blogService;


    @PostMapping(value = "/blog")
    public ModelAndView  insertBlog(Blog blog){
        ModelAndView mv=new ModelAndView();
        //配合查找
        blog.setTags(","+blog.getTags()+",");
        mv.setViewName("admin/tip");
        if (blogService.addBlog(blog)==1){
            mv.addObject("message","Blog saved successfully!");
        }else {
            mv.addObject("message","Failed to save blog!");
        }
        return mv;
    }
    @DeleteMapping(value = "/blog")
    public ModelAndView  deleteBlog(@RequestParam Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.deleteBlog(id)==1){
            mv.addObject("message","Blog deleted successfully!");
        }else {
            mv.addObject("message","Failed to delete blog!");
        }
        return mv;
    }
    @PutMapping(value = "/blog")
    public ModelAndView  update(Blog blog){
        blog.setTags(","+blog.getTags()+",");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.updateBlog(blog)==1){
            mv.addObject("message","Blog updated successfully!");
        }else {
            mv.addObject("message","Failed to update blog!");
        }
        return mv;
    }
}
