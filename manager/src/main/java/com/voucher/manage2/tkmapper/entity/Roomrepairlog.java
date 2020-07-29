package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[RoomRepairLog]")
public class Roomrepairlog implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[RoomAddress]")
    private String roomaddress;

    @Column(name = "[RoomCount]")
    private Double roomcount;

    @Column(name = "[Area]")
    private Double area;

    @Column(name = "[Type]")
    private String type;

    @Column(name = "[RepairDate]")
    private Date repairdate;

    @Column(name = "[RepairItem]")
    private String repairitem;

    @Column(name = "[AmountTotal]")
    private Double amounttotal;

    @Column(name = "[Amount]")
    private Double amount;

    @Column(name = "[AuditingAmount]")
    private Double auditingamount;

    @Column(name = "[WorkUnit]")
    private String workunit;

    @Column(name = "[AvailabeLength]")
    private String availabelength;

    @Column(name = "[Memo]")
    private String memo;

    @Column(name = "[Operator]")
    private String operator;

    @Column(name = "[BelongUnit]")
    private String belongunit;

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
     * @return RoomAddress
     */
    public String getRoomaddress() {
        return roomaddress;
    }

    /**
     * @param roomaddress
     */
    public void setRoomaddress(String roomaddress) {
        this.roomaddress = roomaddress == null ? null : roomaddress.trim();
    }

    /**
     * @return RoomCount
     */
    public Double getRoomcount() {
        return roomcount;
    }

    /**
     * @param roomcount
     */
    public void setRoomcount(Double roomcount) {
        this.roomcount = roomcount;
    }

    /**
     * @return Area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return RepairDate
     */
    public Date getRepairdate() {
        return repairdate;
    }

    /**
     * @param repairdate
     */
    public void setRepairdate(Date repairdate) {
        this.repairdate = repairdate;
    }

    /**
     * @return RepairItem
     */
    public String getRepairitem() {
        return repairitem;
    }

    /**
     * @param repairitem
     */
    public void setRepairitem(String repairitem) {
        this.repairitem = repairitem == null ? null : repairitem.trim();
    }

    /**
     * @return AmountTotal
     */
    public Double getAmounttotal() {
        return amounttotal;
    }

    /**
     * @param amounttotal
     */
    public void setAmounttotal(Double amounttotal) {
        this.amounttotal = amounttotal;
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
     * @return AuditingAmount
     */
    public Double getAuditingamount() {
        return auditingamount;
    }

    /**
     * @param auditingamount
     */
    public void setAuditingamount(Double auditingamount) {
        this.auditingamount = auditingamount;
    }

    /**
     * @return WorkUnit
     */
    public String getWorkunit() {
        return workunit;
    }

    /**
     * @param workunit
     */
    public void setWorkunit(String workunit) {
        this.workunit = workunit == null ? null : workunit.trim();
    }

    /**
     * @return AvailabeLength
     */
    public String getAvailabelength() {
        return availabelength;
    }

    /**
     * @param availabelength
     */
    public void setAvailabelength(String availabelength) {
        this.availabelength = availabelength == null ? null : availabelength.trim();
    }

    /**
     * @return Memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
     * @return BelongUnit
     */
    public String getBelongunit() {
        return belongunit;
    }

    /**
     * @param belongunit
     */
    public void setBelongunit(String belongunit) {
        this.belongunit = belongunit == null ? null : belongunit.trim();
    }
}