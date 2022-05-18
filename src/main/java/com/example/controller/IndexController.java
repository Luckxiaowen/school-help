package com.example.controller;

import com.example.domain.ResponseResult;
import com.example.domain.entity.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private TaskService taskService;



    @RequestMapping({"/index","/"})
    public String index(Model md){
        List<Task> taskList = taskService.getLatestTask();
        md.addAttribute("taskList",taskList);
        return "index";
    }
    @RequestMapping("/test")
    @ResponseBody
    public ResponseResult test(){
        return ResponseResult.okResult(taskService.list());
    }
}
