package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.entity.GoodsClassify;
import com.example.mapper.GoodsClassifyMapper;
import com.example.service.GoodsClassifyService;
import org.springframework.stereotype.Service;

/**
 * (GoodsClassify)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 11:11:17
 */
@Service("goodsClassifyService")
public class GoodsClassifyServiceImpl extends ServiceImpl<GoodsClassifyMapper, GoodsClassify> implements GoodsClassifyService {

}

