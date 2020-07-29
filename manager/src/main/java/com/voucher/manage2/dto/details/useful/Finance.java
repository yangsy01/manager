package com.voucher.manage2.dto.details.useful;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 财务信息
 */
@Data
public class Finance {

    private Date indate;   //入账时间
    private Double befromamount;   //历史来源价值
    private Double originalamount;   //资产成本
    private Double networth;   //资产净值
    private Double useYear;   //使用年限  0
    private Double depreciationyear;   //已提年限
    private Double alldepreciation;   //累计折旧
    private String evaluationunit;   //评估机构
    private String evaluationno;   //评估号
    private Double evaluationprice;   //公允价值
    private Double evaluationsingleprice;   //资产单价
    private Date evaluationplace;   //评估时间
    private Double markethire;   //市场租金
    private String ispawn;   //是否抵押
    private String pawnunit;   //抵押单位
    private String originalunit;   //代管资产原所属单位
    private String financememo;   //财务备注

}
