package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[HireList]")
public class Hirelist implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[HireDate]")
    private String hiredate;

    @Column(name = "[BeginDate]")
    private Date begindate;

    @Column(name = "[EndDate]")
    private Date enddate;

    @Column(name = "[Instruction]")
    private String instruction;

    @Column(name = "[Hire]")
    private Double hire;

    @Column(name = "[ChartCriterion]")
    private Double chartcriterion;

    @Column(name = "[State]")
    private String state;

    @Column(name = "[PayFashion]")
    private String payfashion;

    @Column(name = "[Operator]")
    private String operator;

    @Column(name = "[OptDate]")
    private Date optdate;

    @Column(name = "[ChartGUID]")
    private String chartguid;

    @Column(name = "[PayGUID]")
    private String payguid;

    @Column(name = "[HireGUID]")
    private String hireguid;

    @Column(name = "[IsAddHire]")
    private Boolean isaddhire;

    @Column(name = "[OptAddDate]")
    private Date optadddate;

    @Column(name = "[OptAddUser]")
    private String optadduser;

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
     * @return HireDate
     */
    public String getHiredate() {
        return hiredate;
    }

    /**
     * @param hiredate
     */
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate == null ? null : hiredate.trim();
    }

    /**
     * @return BeginDate
     */
    public Date getBegindate() {
        return begindate;
    }

    /**
     * @param begindate
     */
    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    /**
     * @return EndDate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return Instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @param instruction
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    /**
     * @return Hire
     */
    public Double getHire() {
        return hire;
    }

    /**
     * @param hire
     */
    public void setHire(Double hire) {
        this.hire = hire;
    }

    /**
     * @return ChartCriterion
     */
    public Double getChartcriterion() {
        return chartcriterion;
    }

    /**
     * @param chartcriterion
     */
    public void setChartcriterion(Double chartcriterion) {
        this.chartcriterion = chartcriterion;
    }

    /**
     * @return State
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return PayFashion
     */
    public String getPayfashion() {
        return payfashion;
    }

    /**
     * @param payfashion
     */
    public void setPayfashion(String payfashion) {
        this.payfashion = payfashion == null ? null : payfashion.trim();
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
     * @return PayGUID
     */
    public String getPayguid() {
        return payguid;
    }

    /**
     * @param payguid
     */
    public void setPayguid(String payguid) {
        this.payguid = payguid == null ? null : payguid.trim();
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
     * @return IsAddHire
     */
    public Boolean getIsaddhire() {
        return isaddhire;
    }

    /**
     * @param isaddhire
     */
    public void setIsaddhire(Boolean isaddhire) {
        this.isaddhire = isaddhire;
    }

    /**
     * @return OptAddDate
     */
    public Date getOptadddate() {
        return optadddate;
    }

    /**
     * @param optadddate
     */
    public void setOptadddate(Date optadddate) {
        this.optadddate = optadddate;
    }

    /**
     * @return OptAddUser
     */
    public String getOptadduser() {
        return optadduser;
    }

    /**
     * @param optadduser
     */
    public void setOptadduser(String optadduser) {
        this.optadduser = optadduser == null ? null : optadduser.trim();
    }
}