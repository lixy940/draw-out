package com.lixy.drawout.dao;

import com.lixy.drawout.JunitConfig;
import com.lixy.drawout.entity.Air3Code;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */

public class Air3CodeMapperTest extends JunitConfig {

    @Autowired
    private Air3CodeMapper air3CodeMapper;


    @Test
    public void test1(){

        List<Air3Code> list = air3CodeMapper.getAll();
        assertNotNull(list);

    }



}