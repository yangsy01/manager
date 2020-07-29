package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[User]")
public class User implements Serializable {
    @Id
    @Column(name = "[UserNo]")
    private String userno;

    @Id
    @Column(name = "[BelongUnit]")
    private String belongunit;

    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[UserName]")
    private String username;

    @Column(name = "[Pwd]")
    private String pwd;

    @Column(name = "[RoleGUID]")
    private String roleguid;

    @Column(name = "[RoleName]")
    private String rolename;

    @Column(name = "[ViewCondition]")
    private String viewcondition;

    private static final long serialVersionUID = 1L;

    /**
     * @return UserNo
     */
    public String getUserno() {
        return userno;
    }

    /**
     * @param userno
     */
    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
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
     * @return Pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * @return RoleGUID
     */
    public String getRoleguid() {
        return roleguid;
    }

    /**
     * @param roleguid
     */
    public void setRoleguid(String roleguid) {
        this.roleguid = roleguid == null ? null : roleguid.trim();
    }

    /**
     * @return RoleName
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * @return ViewCondition
     */
    public String getViewcondition() {
        return viewcondition;
    }

    /**
     * @param viewcondition
     */
    public void setViewcondition(String viewcondition) {
        this.viewcondition = viewcondition == null ? null : viewcondition.trim();
    }
}