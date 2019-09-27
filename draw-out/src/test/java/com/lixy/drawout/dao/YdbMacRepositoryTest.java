package com.lixy.drawout.dao;

import com.lixy.drawout.entity.YdbMac;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Author：MR LIS，2019/9/19
 * Copyright(C) 2019 All rights reserved.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YdbMacRepositoryTest {

    @Autowired
    private YdbMacMapper ydbMacDao;


    @Test
    public void insert() {

        YdbMac m = new YdbMac();
        m.setCollectTime(LocalDateTime.parse("2019-09-25 13:23:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        m.setIp("192.168.19.121");
        /*m.setAgentNum("");
        m.setCreator("");
        m.setFlag("");
        m.setMac("");*/
        m.setPointId("11111111111");
        m.setDetail("描述");
        m.setRksj(new Date());
        ydbMacDao.insert(m);

    }


}