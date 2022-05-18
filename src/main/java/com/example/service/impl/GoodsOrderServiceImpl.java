package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.entity.GoodsOrder;
import com.example.mapper.GoodsOrderMapper;
import com.example.service.GoodsOrderService;
import org.springframework.stereotype.Service;

/**
 * (GoodsOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@Service("goodsOrderService")
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderMapper, GoodsOrder> implements GoodsOrderService {

}

