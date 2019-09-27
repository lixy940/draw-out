package com.lixy.drawout.service;

import com.lixy.drawout.dao.Air3CodeMapper;
import com.lixy.drawout.dao.CubeAirportMapper;
import com.lixy.drawout.entity.Air3Code;
import com.lixy.drawout.entity.CubeAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
@Service
public class AssembleAirpotServiceImpl implements AssembleAirpotService {

    @Autowired
    private Air3CodeMapper air3CodeMapper;

    @Autowired
    private CubeAirportMapper cubeAirportMapper;

    @Override
    public void assemble() {

        List<Air3Code> air3CodeList = air3CodeMapper.getAll();

        List<CubeAirport> cubeAirportList = cubeAirportMapper.getAll();

        List<CubeAirport> targetList = new ArrayList<>();

        List<String> air_3_code_list = air3CodeList.stream()
                .map(Air3Code::getA_code)
                .collect(toList());

        List<String> not_exit_air_3_list = new ArrayList<>();

        Map<String, Air3Code> air3CodeMap = air3CodeList.stream()
                .collect(Collectors.toMap(k -> k.getA_code(), v -> v));

        for (CubeAirport cubeAirport : cubeAirportList) {
            if (!air_3_code_list.contains(cubeAirport.getCode())) {
                not_exit_air_3_list.add(cubeAirport.getCode());
                targetList.add(cubeAirport);
            }else{
                Air3Code air3Code = air3CodeMap.get(cubeAirport.getCode());
                cubeAirport.setC_code(air3Code.getC_code());
                targetList.add(cubeAirport);
            }
        }

        List<String> cube_air_list = cubeAirportList.stream()
                .map(CubeAirport::getCode)
                .collect(toList());

        List<String> not_exit_cube_air_list = new ArrayList<>();
        for (Air3Code air3Code : air3CodeList) {
            if (!cube_air_list.contains(air3Code.getA_code())) {
                CubeAirport cubeAirport = new CubeAirport();
                cubeAirport.setCode(air3Code.getA_code());
                cubeAirport.setFull_name(air3Code.getA_name());
                cubeAirport.setC_code(air3Code.getC_code());
                cubeAirport.setC_name(air3Code.getC_name());
                String c_location = air3Code.getC_location();
                String[] arr = c_location.split(",");
                cubeAirport.setLongitude(arr[1]);
                cubeAirport.setLatitude(arr[0]);
                cubeAirport.setCountry_en("China");
                cubeAirport.setCountry_cn("中国");
                targetList.add(cubeAirport);
                not_exit_cube_air_list.add(air3Code.getA_code());
            }
        }

        for (CubeAirport cubeAirport : targetList) {
            cubeAirport.setId(null);
//            cubeAirportMapper.insert(cubeAirport);
        }
        System.out.println(not_exit_air_3_list);
        System.out.println(not_exit_cube_air_list);

    }
}
