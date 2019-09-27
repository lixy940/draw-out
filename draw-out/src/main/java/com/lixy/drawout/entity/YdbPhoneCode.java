package com.lixy.drawout.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author：MR LIS，2019/9/19
 * Copyright(C) 2019 All rights reserved.
 */
/*@Entity
@Table(name = "ydb_phone_code_test", schema = "guiping")*/
public class YdbPhoneCode implements Serializable {

    private Integer numId;
    private String imsi;
    private String imei;
    private String pointId;
    private String carrier;
    private String attribution;
    private LocalDateTime collectTime;
    private String agentNum;
    private String collectNum;
    private String cq;
    private String phoneModel;
    private LocalDateTime rksj;

    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public LocalDateTime getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
    }

    public String getAgentNum() {
        return agentNum;
    }

    public void setAgentNum(String agentNum) {
        this.agentNum = agentNum;
    }

    public String getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(String collectNum) {
        this.collectNum = collectNum;
    }

    public String getCq() {
        return cq;
    }

    public void setCq(String cq) {
        this.cq = cq;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public LocalDateTime getRksj() {
        return rksj;
    }

    public void setRksj(LocalDateTime rksj) {
        this.rksj = rksj;
    }
}
