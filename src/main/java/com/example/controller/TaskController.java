package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.example.domain.ResponseResult;
import com.example.domain.entity.Task;
import com.example.domain.entity.TaskClassify;
import com.example.domain.entity.User;
import com.example.enums.AppHttpCodeEnum;
import com.example.service.TaskClassifyService;
import com.example.service.TaskService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskClassifyService taskClassifyService;


    @GetMapping("/info/{id}")
    public String taskInfo(@PathVariable("id") Integer id, Model md){
        Task task = taskService.getById(id);
        md.addAttribute("taskInfo",task);

        return "taskinfo";
    }

    @RequestMapping("/list")
    public String taskList(Integer classId,Model md){
        //查询任务
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getIsReceive,0);
        queryWrapper.eq(Task::getIsOver,0);
        if (classId != null){
            queryWrapper.eq(Task::getClassifyId,classId);
        }
        List<Task> taskList = taskService.list(queryWrapper);

        //查询任务分类List
        List<TaskClassify> classifyList = taskClassifyService.list();

        md.addAttribute("taskList",taskList);
        md.addAttribute("taskClass",classifyList);

        return "tasklist";
    }

    /**
     * 接受任务
     */
    @PostMapping("/accept/{id}")
    @ResponseBody
    public ResponseResult acceptTask(@PathVariable("id") Integer taskId){

        if (taskId == null)return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        return taskService.acceptTask(taskId);
    }



}
