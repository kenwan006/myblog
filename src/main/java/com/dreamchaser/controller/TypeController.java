package com.dreamchaser.controller;

import com.dreamchaser.pojo.Type;
import com.dreamchaser.service.TypeService;
import com.dreamchaser.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 金昊霖
 */
@Controller
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping(value = "/type")
    public String findTypes(@RequestParam Map<String,Object> map, Model model){
        model.addAttribute("types",typeService.findTypeByPage(MapUtil.handle(map)));
        return "admin/types::table_refresh";
    }

    @PostMapping(value = "/type")
    public ModelAndView insertType(Type type){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (typeService.addType(type)==1){
            mv.addObject("message","Saved Category successfully!");
        }else {
            mv.addObject("message","Failed to Save Category!");
        }
        return mv;
    }

    @DeleteMapping(value = "/type")
    public ModelAndView  deleteType(@RequestParam Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (typeService.deleteTypeById(id)==1){
            mv.addObject("message","Delete Category successfully!");
        }else {
            mv.addObject("message","Failed to Delete Category!");
        }
        return mv;
    }
    @PutMapping(value = "/type")
    public ModelAndView  update(Type type){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (typeService.updateType(type)==1){
            mv.addObject("message","Updated Category successfully!");
        }else {
            mv.addObject("message","Failed to Update Category!!");
        }
        return mv;
    }

}
