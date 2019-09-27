package com.lixy.drawout.dao;

import com.lixy.drawout.entity.YdbPhoneCode;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * Author：MR LIS，2019/9/19
 * Copyright(C) 2019 All rights reserved.
 */
@Repository
public interface YdbPhoneCodeMapper {

    @Insert("insert into guiping.ydb_phone_code(agent_num,attribution,carrier,collect_num,cq,collect_time,imei,imsi,phone_model,point_id,rksj) " +
            " values(#{agentNum},#{attribution},#{carrier},#{collectNum},#{cq},#{collectTime},#{imei},#{imsi},#{phoneModel},#{pointId},#{rksj})")
    int insert(YdbPhoneCode ydbPhoneCode);
}
