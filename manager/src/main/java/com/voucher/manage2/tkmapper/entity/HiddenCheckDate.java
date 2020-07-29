package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[Hidden_Check_Date]")
public class HiddenCheckDate implements Serializable {
    @Column(name = "[check_id]")
    private String checkId;

    @Column(name = "[NAME]")
    private String name;

    @Column(name = "[TYPE]")
    private String type;

    @Column(name = "[URI]")
    private String uri;

    @Column(name = "[date]")
    private Date date;

    @Column(name = "[FileBelong]")
    private String filebelong;

    @Column(name = "[FileIndex]")
    private Integer fileindex;

    private static final long serialVersionUID = 1L;

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
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return TYPE
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
     * @return URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
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
     * @return FileBelong
     */
    public String getFilebelong() {
        return filebelong;
    }

    /**
     * @param filebelong
     */
    public void setFilebelong(String filebelong) {
        this.filebelong = filebelong == null ? null : filebelong.trim();
    }

    /**
     * @return FileIndex
     */
    public Integer getFileindex() {
        return fileindex;
    }

    /**
     * @param fileindex
     */
    public void setFileindex(Integer fileindex) {
        this.fileindex = fileindex;
    }
}