package com.voucher.manage2.dto.details.useful;

import lombok.Data;

import javax.persistence.Column;

/**
 * 产权信息
 */
@Data
public class Equities {

    private String propertyrightno;   //房产证号
    private String glebecardno;   //土地证号
    private String realestateno;   //川2015泸州市不动产权第0020558号,不动产证
    private Double propertyrightarea;   //产权面积
    private Double landarea;   //土地证面积
    private String befrom;   //房屋来源
    private String propertyrightunit;   //产权单位
    private String realpropertyrightunit;   //实际产权单位
    private String propertycardunit;   //房产证证载权属单位
    private String glebecardunit;   //土地证证载权属单位
    private String befromfile;   //产权来源文件
    private String transferunit;   //移交单位
    private Integer buildyear;   //建筑年份
    private String designuseful;   //设计用途
    private String planuseful;   //规划用途
    private String glebetypeuseful;   //地类用途
    private String glebeusetype;   //使用权类型
    private String glebeenddate;   //土地到期年限
    private String notPerfectRoom; //未完善房产证说明 0
    private String notPerfectLand; //未完善土地证说明 0
    private String equitiesMemo;   //产权备注 0



}
