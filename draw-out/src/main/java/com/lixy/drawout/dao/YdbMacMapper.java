package com.lixy.drawout.dao;

import com.lixy.drawout.entity.YdbMac;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * Author：MR LIS，2019/9/19
 * Copyright(C) 2019 All rights reserved.
 */
@Repository
public interface YdbMacMapper {

    @Insert("insert into guiping.ydb_mac(agent_num,collect_time,creator,detail,flag,ip,mac,point_id,rksj) " +
            "values(#{agentNum},#{collectTime},#{creator},#{detail},#{flag},#{ip},#{mac},#{pointId},#{rksj})")
    int insert(YdbMac m);
}
