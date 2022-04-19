package com.example.sdust_confession_wall.controller;

import com.example.sdust_confession_wall.mapper.UserMapper;
import com.example.sdust_confession_wall.model.User;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * @author Joker
 * @data 2022/4/17 17:56
 */
@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(){return "login";}
    @PostMapping("/login")
    public String dologin(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            HttpServletRequest request,
            Model model){
        model.addAttribute("username",username);
        if(username == null || username.equals("")){
            model.addAttribute("error","用户名不能为空");
            return "login";
        }
        if(password == null || password.equals("")){
            model.addAttribute("error","密码不能为空");
            return "login";
        }
        String MD5password = DigestUtils.md5DigestAsHex(password.getBytes());
        model.addAttribute("password",MD5password);
        if(MD5password.equals(userMapper.findpassbyname(username)))
        {
            HttpSession session = request.getSession();
            User user = new User();
            user.setId(userMapper.findidbyname(username));
            user.setUsername(username);
            session.setAttribute("Loginuser",user);
            return "redirect:/";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

}
