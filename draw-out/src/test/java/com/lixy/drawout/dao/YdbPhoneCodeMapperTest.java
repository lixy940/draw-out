package com.lixy.drawout.dao;

import com.lixy.drawout.entity.YdbPhoneCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author：MR LIS，2019/9/19
 * Copyright(C) 2019 All rights reserved.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YdbPhoneCodeMapperTest {

    @Autowired
    private YdbPhoneCodeMapper ydbPhoneCodeMapper;

    @Test
    public void insert(){
        YdbPhoneCode vo = new YdbPhoneCode();
        vo.setAgentNum("1");
        vo.setImsi("2342");
        ydbPhoneCodeMapper.insert(vo);
    }
}