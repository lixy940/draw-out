package com.lixy.drawout.dao;

import com.lixy.drawout.JunitConfig;
import com.lixy.drawout.entity.CubeAirport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
public class CubeAirportMapperTest extends JunitConfig {


    @Autowired
    private CubeAirportMapper cubeAirportMapper;

    @Test
    public void test(){
        List<CubeAirport> list = cubeAirportMapper.getAll();
        System.out.println(list);
    }

}