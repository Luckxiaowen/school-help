package com.example.domain.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (GoodsOrder)表实体类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods_order")
public class GoodsOrder  {
    //商品订单ID@TableId
    @TableId
    private Integer id;

    //订单号
    private String orderNumber;
    //商品ID
    private Integer goodsId;
    //卖家ID
    private Integer sellerId;
    //买家ID
    private Integer buyerId;
    //交易金额
    private Integer totalPrice;
    //是否完成此订单 0未完成 1完成
    private Integer isOver;
    //创建时间
    private Date creatTime;



}
