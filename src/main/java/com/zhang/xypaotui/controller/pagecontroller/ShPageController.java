package com.zhang.xypaotui.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("shInformation")
public class ShPageController {
    @RequestMapping("toShFor")
    public ModelAndView toSHFor(){
        return new ModelAndView("/table/shFor");
    }
    @RequestMapping("toShIdle")
    public ModelAndView toShIdle(){
        return new ModelAndView("/table/toShIdle");
    }
    @RequestMapping("toShjob")
    public ModelAndView toShjob(){
        return new ModelAndView("/table/toShJob");
    }
    @RequestMapping("toShLost")
    public ModelAndView toShLost(){
        return new ModelAndView("/table/toShLost");
    }
}
