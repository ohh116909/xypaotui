package com.zhang.xypaotui.service;


import com.dtflys.forest.annotation.Get;
import org.springframework.stereotype.Service;

@Service
public interface SendService {
    @Get("https://api.smsbao.com/sms?u={0}&p={1}&m={2}&c={3}")
    String sendSms(String username, String password, String phone, String content);


    @Get("http://api.smsbao.com/query?u={0}&p={1}")
    String checkBalance(String username, String password);

}
