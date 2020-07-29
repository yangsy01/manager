package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[ClassicQuery]")
public class Classicquery implements Serializable {
    @Column(name = "[ID]")
    private Integer id;

    @Column(name = "[RoteLevel]")
    private Integer rotelevel;

    @Column(name = "[RoteName]")
    private String rotename;

    @Column(name = "[FiledName]")
    private String filedname;

    @Column(name = "[ValueFrom]")
    private String valuefrom;

    @Column(name = "[RoteValues]")
    private String rotevalues;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
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
     * @return RoteLevel
     */
    public Integer getRotelevel() {
        return rotelevel;
    }

    /**
     * @param rotelevel
     */
    public void setRotelevel(Integer rotelevel) {
        this.rotelevel = rotelevel;
    }

    /**
     * @return RoteName
     */
    public String getRotename() {
        return rotename;
    }

    /**
     * @param rotename
     */
    public void setRotename(String rotename) {
        this.rotename = rotename == null ? null : rotename.trim();
    }

    /**
     * @return FiledName
     */
    public String getFiledname() {
        return filedname;
    }

    /**
     * @param filedname
     */
    public void setFiledname(String filedname) {
        this.filedname = filedname == null ? null : filedname.trim();
    }

    /**
     * @return ValueFrom
     */
    public String getValuefrom() {
        return valuefrom;
    }

    /**
     * @param valuefrom
     */
    public void setValuefrom(String valuefrom) {
        this.valuefrom = valuefrom == null ? null : valuefrom.trim();
    }

    /**
     * @return RoteValues
     */
    public String getRotevalues() {
        return rotevalues;
    }

    /**
     * @param rotevalues
     */
    public void setRotevalues(String rotevalues) {
        this.rotevalues = rotevalues == null ? null : rotevalues.trim();
    }
}