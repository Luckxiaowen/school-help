package com.example.domain.entity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Goods)表实体类
 *
 * @author makejava
 * @since 2022-05-13 11:11:15
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods  {
    //商品ID
    @TableId
    private Integer id;

    //商品名
    private String goodsName;
    //商品价格
    private Integer goodsPrice;
    //商品数量
    private Integer goodsCount;
    //商品分类ID
    private Integer goodsClassifyId;
    //发布商品用户ID
    private Integer releaseUserId;
    //发布用户昵称
    private String releaseUserNickname;
    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "release_date", fill = FieldFill.INSERT)
    private Date releaseTime;



}
