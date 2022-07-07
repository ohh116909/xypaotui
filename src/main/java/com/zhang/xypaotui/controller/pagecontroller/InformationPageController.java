package com.zhang.xypaotui.controller.pagecontroller;

import com.zhang.xypaotui.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/information")
public class InformationPageController {

    @RequestMapping("/toFor")
    public ModelAndView toFor(){
        return new ModelAndView("/table/informationFor");
    }
    @RequestMapping("toLost")
    public ModelAndView toLost(){
        return new ModelAndView("/table/informationLost");
    }
    @RequestMapping("toPart")
    public ModelAndView toPart(){
        return new ModelAndView("/table/informationPart");
    }
    @RequestMapping("toIdle")
    public ModelAndView toIdle(){
        return new ModelAndView("/table/informationIdle");
    }
}
