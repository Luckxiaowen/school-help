package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.entity.User;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 11:11:20
 */
public interface UserService extends IService<User> {

    public User findByUsername(String username);
}

