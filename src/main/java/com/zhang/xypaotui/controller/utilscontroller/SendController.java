package com.zhang.xypaotui.controller.utilscontroller;

import com.zhang.xypaotui.pojo.SendAPI;
import com.zhang.xypaotui.service.SendService;
import com.zhang.xypaotui.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("/utils")
public class SendController {

    @Autowired
    private SendService sendService;

    @RequestMapping("/sendcode")
    public void getSendCode(HttpServletRequest request, @RequestParam("phone") String telephone){
        System.out.println(telephone);
        String codes = CodeUtils.getCode();
        String sendContent = "【校园跑腿】您的验证码是:"+codes+",５分钟内有效。若非本人操作请忽略此消息";
        sendService.sendSms(SendAPI.user, SendAPI.password, telephone, sendContent);
        HttpSession session = request.getSession();
        session.setAttribute("code",codes);
        this.removeAttrbute(session,"code");
    }

    private void removeAttrbute(final HttpSession session, final String code) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 删除session中存的验证码
                session.removeAttribute(code);
                timer.cancel();
            }
        }, 5 * 60 * 1000);
    }
}
