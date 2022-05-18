package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.entity.TaskClassify;
import com.example.mapper.TaskClassifyMapper;
import com.example.service.TaskClassifyService;
import org.springframework.stereotype.Service;

/**
 * (TaskClassify)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@Service("taskClassifyService")
public class TaskClassifyServiceImpl extends ServiceImpl<TaskClassifyMapper, TaskClassify> implements TaskClassifyService {

}

