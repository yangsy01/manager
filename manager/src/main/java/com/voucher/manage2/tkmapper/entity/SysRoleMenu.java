package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[sys_role_menu]")
public class SysRoleMenu implements Serializable {
    @Column(name = "[guid]")
    private String guid;

    @Column(name = "[role_guid]")
    private String roleGuid;

    @Column(name = "[menu_guid]")
    private String menuGuid;

    private static final long serialVersionUID = 1L;

    /**
     * @return guid
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
     * @return role_guid
     */
    public String getRoleGuid() {
        return roleGuid;
    }

    /**
     * @param roleGuid
     */
    public void setRoleGuid(String roleGuid) {
        this.roleGuid = roleGuid == null ? null : roleGuid.trim();
    }

    /**
     * @return menu_guid
     */
    public String getMenuGuid() {
        return menuGuid;
    }

    /**
     * @param menuGuid
     */
    public void setMenuGuid(String menuGuid) {
        this.menuGuid = menuGuid == null ? null : menuGuid.trim();
    }
}