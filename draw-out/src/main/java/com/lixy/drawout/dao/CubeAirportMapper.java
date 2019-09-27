package com.lixy.drawout.dao;

import com.lixy.drawout.entity.CubeAirport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
@Repository
public interface CubeAirportMapper {


    @Select("select * from cube_airport_copy")
    List<CubeAirport> getAll();

    @Insert("insert into cube_airport(c_code,c_name,full_name,code,country_cn,country_en,longitude,latitude) " +
            "values(#{c_code},#{c_name},#{full_name},#{code},#{country_cn},#{country_en},#{longitude},#{latitude})")
    int insert(CubeAirport cubeAirport);

}
