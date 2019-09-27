package com.lixy.drawout.entity;

/**
 * Author：MR LIS，2019/9/20
 * Copyright(C) 2019 All rights reserved.
 */
public class CubeAirport {


    private Integer id;
    private String c_code;
    private String c_name;
    private String full_name;
    private String code;
    private String longitude;
    private String latitude;
    private String country_cn;
    private String country_en;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCountry_cn() {
        return country_cn;
    }

    public void setCountry_cn(String country_cn) {
        this.country_cn = country_cn;
    }

    public String getCountry_en() {
        return country_en;
    }

    public void setCountry_en(String country_en) {
        this.country_en = country_en;
    }
}
