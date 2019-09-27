package com.lixy.drawout.dao;

import com.lixy.drawout.entity.Air3Code;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
@Repository
public interface Air3CodeMapper {

    @Select("select * from air_3rd_code")
    List<Air3Code> getAll();

}
