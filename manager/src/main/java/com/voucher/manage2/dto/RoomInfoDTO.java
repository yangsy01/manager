package com.voucher.manage2.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RoomInfoDTO {
    private String roomGuid;            //roomInfo的guid

    private String address;         //地址
    private String num;             //编号
    private String roomProperty;    //房屋性质
    private Double buildArea;       //建筑面积
    private String state;           //房屋状况
    private String charter;         //承租人
    private Double totalHire;       //总租金
    private String structure;       //房屋结构
    private String sMemo;           //备注

}
