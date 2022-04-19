package com.example.sdust_confession_wall.controller;

import com.example.sdust_confession_wall.mapper.QuestionMapper;
import com.example.sdust_confession_wall.model.Question;
import com.example.sdust_confession_wall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Create by LQZ on 2022/4/17
 */
@Controller
public class PublishController {
    /*
    如果是get，则渲染页面，如果是post，则去执行请求；
     */
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest request,
            Model model){

        User user = null;
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("Loginuser");

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(user == null){
            model.addAttribute("error","登录失效,请重新登录");
            return "publish";
        }
        if(title == null || title.equals("")){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(description == null || description.equals("")){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if(tag == null || tag.equals("")){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
