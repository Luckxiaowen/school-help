package com.example.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-05-13 11:11:18
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User  {
    //用户ID@TableId
    @TableId
    private Integer id;

    //密码
    private String password;
    //用户名
    private String username;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //电话
    private String tel;
    //昵称
    private String nickName;



}
