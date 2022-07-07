package com.zhang.xypaotui.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String toIndex(){
        return "login";
    }
    @RequestMapping("/toResiter")
    public String ToResiter(){
        return "loginSignup";
    }
    @RequestMapping("/toIndex")
    public String ToIndex(){
        return "index";
    }
    @RequestMapping("/toinformation")
    public String ToInfor(){
        return "information";
    }
    @RequestMapping("/toShInfor")
    public String ToShInfo(){
        return "shInformation";
    }
    @RequestMapping("/toview")
    public String Toview(){
        return "view";
    }
}
