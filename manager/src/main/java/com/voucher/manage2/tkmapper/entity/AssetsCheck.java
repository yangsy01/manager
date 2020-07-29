package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[Assets_Check]")
public class AssetsCheck implements Serializable {
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[exist]")
    private Integer exist;

    @Column(name = "[check_id]")
    private String checkId;

    @Column(name = "[check_name]")
    private String checkName;

    @Column(name = "[principal]")
    private String principal;

    @Column(name = "[happen_time]")
    private Date happenTime;

    @Column(name = "[update_time]")
    private Date updateTime;

    @Column(name = "[date]")
    private Date date;

    @Column(name = "[remark]")
    private String remark;

    @Column(name = "[campusAdmin]")
    private String campusadmin;

    @Column(name = "[terminal]")
    private String terminal;

    @Column(name = "[check_circs]")
    private String checkCircs;

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
     * @return check_id
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     * @param checkId
     */
    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    /**
     * @return check_name
     */
    public String getCheckName() {
        return checkName;
    }

    /**
     * @param checkName
     */
    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
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
}