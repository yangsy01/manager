package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[HirePay]")
public class Hirepay implements Serializable {
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[Amount]")
    private Double amount;

    @Column(name = "[PrintMemo]")
    private String printmemo;

    @Column(name = "[PrintCount]")
    private Double printcount;

    @Column(name = "[Operator]")
    private String operator;

    @Column(name = "[OptDate]")
    private Date optdate;

    @Column(name = "[TicketNo]")
    private String ticketno;

    @Column(name = "[ChartGUID]")
    private String chartguid;

    @Column(name = "[HireGUID]")
    private String hireguid;

    @Column(name = "[InType]")
    private String intype;

    @Column(name = "[out_trade_no]")
    private String outTradeNo;

    @Column(name = "[campusId]")
    private Integer campusid;

    private static final long serialVersionUID = 1L;

    /**
     * @return GUID
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     * @return Amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return PrintMemo
     */
    public String getPrintmemo() {
        return printmemo;
    }

    /**
     * @param printmemo
     */
    public void setPrintmemo(String printmemo) {
        this.printmemo = printmemo == null ? null : printmemo.trim();
    }

    /**
     * @return PrintCount
     */
    public Double getPrintcount() {
        return printcount;
    }

    /**
     * @param printcount
     */
    public void setPrintcount(Double printcount) {
        this.printcount = printcount;
    }

    /**
     * @return Operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * @return OptDate
     */
    public Date getOptdate() {
        return optdate;
    }

    /**
     * @param optdate
     */
    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    /**
     * @return TicketNo
     */
    public String getTicketno() {
        return ticketno;
    }

    /**
     * @param ticketno
     */
    public void setTicketno(String ticketno) {
        this.ticketno = ticketno == null ? null : ticketno.trim();
    }

    /**
     * @return ChartGUID
     */
    public String getChartguid() {
        return chartguid;
    }

    /**
     * @param chartguid
     */
    public void setChartguid(String chartguid) {
        this.chartguid = chartguid == null ? null : chartguid.trim();
    }

    /**
     * @return HireGUID
     */
    public String getHireguid() {
        return hireguid;
    }

    /**
     * @param hireguid
     */
    public void setHireguid(String hireguid) {
        this.hireguid = hireguid == null ? null : hireguid.trim();
    }

    /**
     * @return InType
     */
    public String getIntype() {
        return intype;
    }

    /**
     * @param intype
     */
    public void setIntype(String intype) {
        this.intype = intype == null ? null : intype.trim();
    }

    /**
     * @return out_trade_no
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * @param outTradeNo
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * @return campusId
     */
    public Integer getCampusid() {
        return campusid;
    }

    /**
     * @param campusid
     */
    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }
}