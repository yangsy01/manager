package com.voucher.manage2.dto.details;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TopMessage {
    @Column(name = "[Address]")     //地址
    private String address;
    @Column(name = "[OriginalAddress]")     //原地址
    private String originaladdress;
    @Column(name = "[Num]")     //编号
    private String num;
    @Column(name = "[BuildArea]")
    private Double buildarea;   //建筑面积
    private Double hire;        //资产租金
    @Column(name = "[ChartGUID]")
    private String chartGuid;      //合同guid

}
