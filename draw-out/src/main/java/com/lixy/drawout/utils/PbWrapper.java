package com.lixy.drawout.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author：MR LIS，2019/9/27
 * Copyright(C) 2019 All rights reserved.
 */
public class PbWrapper implements Serializable {

    private Map<?, ?> map;

    private List<?> list;

    public Map<?, ?> getMap() {
        return map;
    }

    public void setMap(Map<?, ?> map) {
        this.map = map;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
