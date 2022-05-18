package com.example.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Task)表实体类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("task")
@Accessors(chain = true)
public class Task  {
    //任务ID@TableId
    @TableId
    private Integer id;

    //任务名称
    private String taskName;
    //任务内容
    private String taskContent;
    //任务金额
    private Integer taskMoney;
    //任务分类ID
    private Integer classifyId;
    //发布人ID
    private Integer releaseUserId;
    //发布人昵称
    private String releaseUserName;
    //接单人ID
    private Integer acceptUserId;
    //接单人昵称
    private String acceptUserName;
    //是否接单 0空闲 1接单中
    private Integer isReceive;
    //是否完成 0未完成 1完成
    private Integer isOver;
    //任务地点
    private String taskPlace;
    //创建时间

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;
    //订单号
    private String orderNumber;
    //封面图片
    private String coverUrl;



}
