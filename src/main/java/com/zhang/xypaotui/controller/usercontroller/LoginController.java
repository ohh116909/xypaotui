package com.zhang.xypaotui.controller.usercontroller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username);
        System.out.println(password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(username,password));
            HttpSession session = request.getSession();
            session.setAttribute("usermsg",username);
            return "index";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        return "login";
    }
}
