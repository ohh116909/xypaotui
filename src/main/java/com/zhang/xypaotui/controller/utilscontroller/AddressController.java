package com.zhang.xypaotui.controller.utilscontroller;

import com.zhang.xypaotui.pojo.BigAddress;
import com.zhang.xypaotui.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/utils")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("dropList")
    @ResponseBody
    public Map<String,Object> getAddress(){
        List<BigAddress> bigAddresses = addressService.selectAll();
        HashMap<String,Object> map = new HashMap<>();
        if(!bigAddresses.isEmpty()){
            map.put("result",bigAddresses);
            map.put("code",100);
        }else{
            map.put("code",200);
            map.put("result","查询失败");
        }
        return map;
    }
}
