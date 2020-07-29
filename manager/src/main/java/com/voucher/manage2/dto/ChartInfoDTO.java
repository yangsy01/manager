package com.voucher.manage2.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChartInfoDTO {

    @Column(name = "[GUID]")
    private String chartGuid;            //chartInfo的guid

    private String contractNo;      //合同编号
    private String charter;         //承租人
    private String roomAddress;     //房屋住址
    private Double area;            //计租面积
    private Double hire;            //月租金
    private Double chartCriterion;  //租赁标准
    private Date concludeDate;      //签订日期
    private Date chartBeginDate;    //合同起始
    private Date chartEndDate;      //合同终止
    private String memo;            //备注

    public String getChartGuid() {
        return chartGuid;
    }

    public void setChartGuid(String chartGuid) {
        this.chartGuid = chartGuid;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCharter() {
        return charter;
    }

    public void setCharter(String charter) {
        this.charter = charter;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getHire() {
        return hire;
    }

    public void setHire(Double hire) {
        this.hire = hire;
    }

    public Double getChartCriterion() {
        return chartCriterion;
    }

    public void setChartCriterion(Double chartCriterion) {
        this.chartCriterion = chartCriterion;
    }

    public Date getConcludeDate() {
//        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
//        String format = slf.format(concludeDate);
//        Date parse = null;
//        try {
//            parse = slf.parse(format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return concludeDate;
    }

    public void setConcludeDate(Date concludeDate) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
        String format = slf.format(concludeDate);
        Date parse = null;
        try {
            parse = slf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.concludeDate = parse;
    }

    public Date getChartBeginDate() {
        return chartBeginDate;
    }

    public void setChartBeginDate(Date chartBeginDate) {
        this.chartBeginDate = chartBeginDate;
    }

    public Date getChartEndDate() {
        return chartEndDate;
    }

    public void setChartEndDate(Date chartEndDate) {
        this.chartEndDate = chartEndDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
