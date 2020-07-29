package com.voucher.manage2.dto.details.useful;

import lombok.Data;

import javax.persistence.Column;

/**
 * 基础信息
 */
@Data
public class Basic {
    private String num;     //编号
    private String originalnum;//原编号
    private String address;  //地址
    private String originaladdress;//原地址
    private String region;          //所在乡镇
    private String manageregion;    //所在社区
    private String segment;     //所在街道
    private Double buildarea;   //建筑面积
    private String structure;   //房屋结构
    private String useful;      //用途
    private String fitment;   //装修情况
    private String floor;   //  楼层
    private String roomtype;   //户型
    private String iscity;   //是否纠纷
    private String isstreet;   //临街
    private String roomproperty;    //房屋性质
    private String state;   //  状态
    private String manager;   //房管员
    private String managerphone;   //联系电话
    private String securityregion;   //资产分类
    private String securityclassification;   //完好等级
    private String dangerclassification;   //危房等级
    private String hiddendanger;   //安全隐患等级
    private String responsibleperson;   //安全负责人
    private String utility;   //纠纷原因
    private String smemo;   //备注信息
    private String tenementInfo;   //物业信息板块
}
