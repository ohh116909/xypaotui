package com.zhang.xypaotui.controller.settingcontroller;


import com.zhang.xypaotui.pojo.Take;
import com.zhang.xypaotui.service.MationForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("submit")
public class SubmitForController {

    @Autowired
    private MationForService mationForService;

    @RequestMapping("saveMationFor")
    @ResponseBody
    public Map<String,String> toSaveFor(@RequestParam("name") String name,
                         @RequestParam("about") String about,
                         @RequestParam("address") String address,
                         @RequestParam("time")String time,
                         @RequestParam("money") String money,
                         @RequestParam("QQ") String qq,
                         @RequestParam("wx") String wx,
                         @RequestParam("phone") String phone,
                         @RequestParam("code") String code,
                         @RequestParam("idname") String Idname,
                         @RequestParam("Daddress")String DAdress){
        String id = UUID.randomUUID().toString();
        double moneys = Double.parseDouble(money);
        String[] ts = time.split("T");
        String times = ts[0]+" "+ts[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime overTime = LocalDateTime.parse(times,formatter);
        LocalDateTime beginTime = LocalDateTime.now();
        Take take = new Take(id,name,about,address,overTime,moneys,qq,wx,phone,code,Idname,beginTime,DAdress);

        HashMap<String,String> map = new HashMap<>();
        try{
            mationForService.save(take);
            map.put("result","发布需求成功");
            map.put("code","100");
            return map;
        }catch (Exception e){
            map.put("result","发布需求失败 数据异常");
            map.put("code","200");
            return map;
        }
    }
}
