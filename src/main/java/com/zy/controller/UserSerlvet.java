package com.zy.controller;

import com.zy.entity.User;
import com.zy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserSerlvet {
     @Autowired
    private UserService userService;
     @RequestMapping("/login")
    public String login(User user, Map map, HttpSession session) {
         System.out.println("name:--->" + user.getUsername());
         System.out.println("pwd:--->" + user.getPassword());
        /* User user1 = userService.query(user);
         System.out.println(user1);*/
         UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
         Subject subject = SecurityUtils.getSubject();
         try {
             subject.login(token);
             return "redirect:main.html";
         } catch (Exception e) {

             map.put("error", "用户名或者密码不正确!");
             return "index";
         }
     }
}
