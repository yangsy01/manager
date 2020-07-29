package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[Hidden_Neaten]")
public class HiddenNeaten implements Serializable {
    @Id
    @Column(name = "[id]")
    private Integer id;

    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[exist]")
    private Integer exist;

    @Column(name = "[neaten_id]")
    private String neatenId;

    @Column(name = "[neaten_name]")
    private String neatenName;

    @Column(name = "[principal]")
    private String principal;

    @Column(name = "[happen_time]")
    private Date happenTime;

    @Column(name = "[neaten_item]")
    private String neatenItem;

    @Column(name = "[update_time]")
    private Date updateTime;

    @Column(name = "[date]")
    private Date date;

    @Column(name = "[campusAdmin]")
    private String campusadmin;

    @Column(name = "[UserName]")
    private String username;

    @Column(name = "[terminal]")
    private String terminal;

    @Column(name = "[progress]")
    private String progress;

    @Column(name = "[is_repair]")
    private Integer isRepair;

    @Column(name = "[RoomGUID]")
    private String roomguid;

    @Column(name = "[Area]")
    private Double area;

    @Column(name = "[Type]")
    private String type;

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

    @Column(name = "[processInstance_id]")
    private String processinstanceId;

    @Column(name = "[check_circs]")
    private String checkCircs;

    @Column(name = "[neaten_instance]")
    private String neatenInstance;

    @Column(name = "[remark]")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return exist
     */
    public Integer getExist() {
        return exist;
    }

    /**
     * @param exist
     */
    public void setExist(Integer exist) {
        this.exist = exist;
    }

    /**
     * @return neaten_id
     */
    public String getNeatenId() {
        return neatenId;
    }

    /**
     * @param neatenId
     */
    public void setNeatenId(String neatenId) {
        this.neatenId = neatenId == null ? null : neatenId.trim();
    }

    /**
     * @return neaten_name
     */
    public String getNeatenName() {
        return neatenName;
    }

    /**
     * @param neatenName
     */
    public void setNeatenName(String neatenName) {
        this.neatenName = neatenName == null ? null : neatenName.trim();
    }

    /**
     * @return principal
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * @param principal
     */
    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    /**
     * @return happen_time
     */
    public Date getHappenTime() {
        return happenTime;
    }

    /**
     * @param happenTime
     */
    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    /**
     * @return neaten_item
     */
    public String getNeatenItem() {
        return neatenItem;
    }

    /**
     * @param neatenItem
     */
    public void setNeatenItem(String neatenItem) {
        this.neatenItem = neatenItem == null ? null : neatenItem.trim();
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return campusAdmin
     */
    public String getCampusadmin() {
        return campusadmin;
    }

    /**
     * @param campusadmin
     */
    public void setCampusadmin(String campusadmin) {
        this.campusadmin = campusadmin == null ? null : campusadmin.trim();
    }

    /**
     * @return UserName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    /**
     * @return progress
     */
    public String getProgress() {
        return progress;
    }

    /**
     * @param progress
     */
    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    /**
     * @return is_repair
     */
    public Integer getIsRepair() {
        return isRepair;
    }

    /**
     * @param isRepair
     */
    public void setIsRepair(Integer isRepair) {
        this.isRepair = isRepair;
    }

    /**
     * @return RoomGUID
     */
    public String getRoomguid() {
        return roomguid;
    }

    /**
     * @param roomguid
     */
    public void setRoomguid(String roomguid) {
        this.roomguid = roomguid == null ? null : roomguid.trim();
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
     * @return processInstance_id
     */
    public String getProcessinstanceId() {
        return processinstanceId;
    }

    /**
     * @param processinstanceId
     */
    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    /**
     * @return check_circs
     */
    public String getCheckCircs() {
        return checkCircs;
    }

    /**
     * @param checkCircs
     */
    public void setCheckCircs(String checkCircs) {
        this.checkCircs = checkCircs == null ? null : checkCircs.trim();
    }

    /**
     * @return neaten_instance
     */
    public String getNeatenInstance() {
        return neatenInstance;
    }

    /**
     * @param neatenInstance
     */
    public void setNeatenInstance(String neatenInstance) {
        this.neatenInstance = neatenInstance == null ? null : neatenInstance.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}