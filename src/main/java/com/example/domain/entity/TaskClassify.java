package com.example.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (TaskClassify)表实体类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("task_classify")
public class TaskClassify  {
    //任务分类ID@TableId
    @TableId
    private Integer id;

    //分类名称
    private String classifyName;



}
