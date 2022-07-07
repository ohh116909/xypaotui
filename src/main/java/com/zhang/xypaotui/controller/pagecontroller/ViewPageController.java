package com.zhang.xypaotui.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("view")
public class ViewPageController {
    @RequestMapping("toFor")
    public ModelAndView toFor(){
        return new ModelAndView("/table/viewFor");
    }
    @RequestMapping("toIdle")
    public ModelAndView toIdle(){
        return new ModelAndView("/table/viewIdle");
    }
    @RequestMapping("toJob")
    public ModelAndView toJob(){
        return new ModelAndView("/table/viewJob");
    }
    @RequestMapping("toLost")
    public ModelAndView toLost(){
        return new ModelAndView("/table/viewLost");
    }
}
