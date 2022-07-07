package com.zhang.xypaotui.controller.viewcontroller;

import com.zhang.xypaotui.pojo.Take;
import com.zhang.xypaotui.service.MationForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewForController {
    @Autowired
    private MationForService mationForService;

    @RequestMapping("/getForAll")
    @ResponseBody
    public Map<String,Object> SelectForAll(){
        HashMap<String,Object> map = new HashMap<>();
        try{
            List<Take> list = mationForService.getAll();
            System.out.println(list);
            map.put("result",list);
            map.put("code","100");
        }catch (Exception e){
            map.put("code","200");
            map.put("result","数据库异常");
        }
        return map;
    }
}
