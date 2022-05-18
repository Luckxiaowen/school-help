package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Task;
import com.example.domain.entity.User;
import com.example.enums.AppHttpCodeEnum;
import com.example.exception.SystemException;
import com.example.service.TaskService;
import com.example.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseResult login(@RequestBody User user, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            User loginUser = (User) subject.getPrincipal();
            subject.getSession().setAttribute("loginUser",loginUser);
            request.getSession().setAttribute("username",loginUser.getUsername());
            return ResponseResult.okResult(200,"登录成功!");
        } catch (UnknownAccountException e) {
            return ResponseResult.errorResult(500,"账号不存在");
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.errorResult(500,"密码错误");
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        request.getSession().removeAttribute("username");
        return "redirect:/index";
    }

    @GetMapping("/user/personal")
    public String toPersonal(Model md){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if (loginUser == null)return "redirect:/login";
        md.addAttribute("user",loginUser);
        return "me";
    }

    @RequestMapping("/user/order")
    public String myOrder(Model md){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getAcceptUserId,loginUser.getId());
        List<Task> taskList = taskService.list(queryWrapper);
        md.addAttribute("taskList",taskList);
        return "order";
    }
    @RequestMapping("/user/release")
    public String myRelease(){
        return "metask";
    }
}
