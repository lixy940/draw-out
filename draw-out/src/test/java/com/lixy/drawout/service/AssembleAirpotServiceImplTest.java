package com.lixy.drawout.service;

import com.lixy.drawout.JunitConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
public class AssembleAirpotServiceImplTest extends JunitConfig {

    @Autowired
    private AssembleAirpotService assembleAirpotService;


    @Test
    public void test(){
        assembleAirpotService.assemble();
    }

}