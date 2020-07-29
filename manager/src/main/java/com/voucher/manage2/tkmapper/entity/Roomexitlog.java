package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[RoomExitLog]")
public class Roomexitlog implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[RoomAddress]")
    private String roomaddress;

    @Column(name = "[RoomCount]")
    private Integer roomcount;

    @Column(name = "[Charter]")
    private String charter;

    @Column(name = "[ExitType]")
    private String exittype;

    @Column(name = "[Hire]")
    private Double hire;

    @Column(name = "[ChartCriterion]")
    private Double chartcriterion;

    @Column(name = "[Area]")
    private Double area;

    @Column(name = "[ConcludeDate]")
    private Date concludedate;

    @Column(name = "[Region]")
    private String region;

    @Column(name = "[ManageRegion]")
    private String manageregion;

    @Column(name = "[RoomProperty]")
    private String roomproperty;

    @Column(name = "[Useful]")
    private String useful;

    @Column(name = "[OriginalUnit]")
    private String originalunit;

    @Column(name = "[BelongUnit]")
    private String belongunit;

    @Column(name = "[OptDate]")
    private Date optdate;

    @Column(name = "[Operator]")
    private String operator;

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
     * @return Charter
     */
    public String getCharter() {
        return charter;
    }

    /**
     * @param charter
     */
    public void setCharter(String charter) {
        this.charter = charter == null ? null : charter.trim();
    }

    /**
     * @return ExitType
     */
    public String getExittype() {
        return exittype;
    }

    /**
     * @param exittype
     */
    public void setExittype(String exittype) {
        this.exittype = exittype == null ? null : exittype.trim();
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
     * @return ConcludeDate
     */
    public Date getConcludedate() {
        return concludedate;
    }

    /**
     * @param concludedate
     */
    public void setConcludedate(Date concludedate) {
        this.concludedate = concludedate;
    }

    /**
     * @return Region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return ManageRegion
     */
    public String getManageregion() {
        return manageregion;
    }

    /**
     * @param manageregion
     */
    public void setManageregion(String manageregion) {
        this.manageregion = manageregion == null ? null : manageregion.trim();
    }

    /**
     * @return RoomProperty
     */
    public String getRoomproperty() {
        return roomproperty;
    }

    /**
     * @param roomproperty
     */
    public void setRoomproperty(String roomproperty) {
        this.roomproperty = roomproperty == null ? null : roomproperty.trim();
    }

    /**
     * @return Useful
     */
    public String getUseful() {
        return useful;
    }

    /**
     * @param useful
     */
    public void setUseful(String useful) {
        this.useful = useful == null ? null : useful.trim();
    }

    /**
     * @return OriginalUnit
     */
    public String getOriginalunit() {
        return originalunit;
    }

    /**
     * @param originalunit
     */
    public void setOriginalunit(String originalunit) {
        this.originalunit = originalunit == null ? null : originalunit.trim();
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
}