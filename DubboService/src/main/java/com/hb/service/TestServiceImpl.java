package com.hb.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author hb
 * @create 2020-07-14 18:18
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getName() {
        return "dubboService";
    }
}
