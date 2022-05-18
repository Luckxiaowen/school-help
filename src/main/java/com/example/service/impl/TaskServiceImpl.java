package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Task;
import com.example.domain.entity.User;
import com.example.enums.AppHttpCodeEnum;
import com.example.mapper.TaskMapper;
import com.example.service.TaskService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * (Task)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Override
    public List<Task> getLatestTask() {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Task::getCreateTime);
        queryWrapper.eq(Task::getIsReceive,0);
        List<Task> taskList = list(queryWrapper);
        return taskList;
    }

    @Override
    public ResponseResult acceptTask(Integer taskId) {
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if (loginUser.getId() == null)return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        Task task = getById(taskId);
        if (task.getIsOver() == 1 || task.getIsReceive() == 1)return ResponseResult.errorResult(500,"任务已被接取");
        //通过UUID生成唯一订单号
        String orderNumber = UUID.randomUUID().toString();
        task.setOrderNumber(orderNumber);
        task.setAcceptUserId(loginUser.getId());
        task.setIsReceive(1);
        boolean res = updateById(task);
        if (!res)return ResponseResult.errorResult(500,"任务接取失败");
        return ResponseResult.okResult(200,"接取成功!");
    }
}

