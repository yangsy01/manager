package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[RoomAssetsLedger]")
public class Roomassetsledger implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[RoomCount]")
    private Integer roomcount;

    @Column(name = "[Residence]")
    private Integer residence;

    @Column(name = "[Business]")
    private Integer business;

    @Column(name = "[Area]")
    private Double area;

    @Column(name = "[Amount]")
    private Double amount;

    @Column(name = "[RelateUnit]")
    private String relateunit;

    @Column(name = "[AssetsLedgerDate]")
    private Date assetsledgerdate;

    @Column(name = "[AssetsLedgerType]")
    private String assetsledgertype;

    @Column(name = "[OptDate]")
    private Date optdate;

    @Column(name = "[Operator]")
    private String operator;

    @Column(name = "[BelongUnit]")
    private String belongunit;

    @Column(name = "[sMemo]")
    private String smemo;

    @Column(name = "[RoomAddress]")
    private String roomaddress;

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
     * @return RoomCount
     */
    public Integer getRoomcount() {
        return roomcount;
    }

    /**
     * @param roomcount
     */
    public void setRoomcount(Integer roomcount) {
        this.roomcount = roomcount;
    }

    /**
     * @return Residence
     */
    public Integer getResidence() {
        return residence;
    }

    /**
     * @param residence
     */
    public void setResidence(Integer residence) {
        this.residence = residence;
    }

    /**
     * @return Business
     */
    public Integer getBusiness() {
        return business;
    }

    /**
     * @param business
     */
    public void setBusiness(Integer business) {
        this.business = business;
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
     * @return RelateUnit
     */
    public String getRelateunit() {
        return relateunit;
    }

    /**
     * @param relateunit
     */
    public void setRelateunit(String relateunit) {
        this.relateunit = relateunit == null ? null : relateunit.trim();
    }

    /**
     * @return AssetsLedgerDate
     */
    public Date getAssetsledgerdate() {
        return assetsledgerdate;
    }

    /**
     * @param assetsledgerdate
     */
    public void setAssetsledgerdate(Date assetsledgerdate) {
        this.assetsledgerdate = assetsledgerdate;
    }

    /**
     * @return AssetsLedgerType
     */
    public String getAssetsledgertype() {
        return assetsledgertype;
    }

    /**
     * @param assetsledgertype
     */
    public void setAssetsledgertype(String assetsledgertype) {
        this.assetsledgertype = assetsledgertype == null ? null : assetsledgertype.trim();
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

    /**
     * @return sMemo
     */
    public String getSmemo() {
        return smemo;
    }

    /**
     * @param smemo
     */
    public void setSmemo(String smemo) {
        this.smemo = smemo == null ? null : smemo.trim();
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
}