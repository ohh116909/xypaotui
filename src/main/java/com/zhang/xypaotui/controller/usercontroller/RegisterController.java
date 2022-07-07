package com.zhang.xypaotui.controller.usercontroller;

import com.zhang.xypaotui.pojo.User;
import com.zhang.xypaotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("telephone") String telephone,
                           @RequestParam("sendcode") String code,
                           HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            String yzcode = (String)session.getAttribute("code");
            if(yzcode.equalsIgnoreCase(code)){
                User user = new User();
                user.setId(UUID.randomUUID().toString());
                user.setUsername(username);
                user.setTelephone(telephone);
                user.setPassword(password);
                LocalDateTime dateTime = LocalDateTime.now();
                user.setCreatTime(dateTime);
                System.out.println(user);
                userService.register(user);
                request.getRequestDispatcher("/");
            }
            session.setAttribute("rigesterErro","注册失败！");
            return "redirect:/register.html";
        }catch (Exception e){
            e.printStackTrace();

            return "redirect:/toIndex";
        }
    }
}
