package com.zhang.xypaotui.controller.settingcontroller;

import com.zhang.xypaotui.service.OssUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/submit")
public class SubmitLostController {

    @Autowired
    private OssUploadService ossUploadService;

    @RequestMapping("/uploader")
    @ResponseBody
    public Map<String,String> upLoader(@RequestParam("file") MultipartFile multipartFile){
        HashMap<String,String> map = new HashMap<>();
        map.put("url",ossUploadService.uploadfile(multipartFile,"lost"));
        System.out.println(map);
        return map;
    }
}
