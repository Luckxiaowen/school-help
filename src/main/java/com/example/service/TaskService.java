package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.domain.ResponseResult;
import com.example.domain.entity.Task;

import java.util.List;


/**
 * (Task)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
public interface TaskService extends IService<Task> {

    List<Task> getLatestTask();

    ResponseResult acceptTask(Integer taskId);
}

