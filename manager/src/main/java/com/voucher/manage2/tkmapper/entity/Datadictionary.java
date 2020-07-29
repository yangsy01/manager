package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[DataDictionary]")
public class Datadictionary implements Serializable {
    @Column(name = "[ID]")
    private Integer id;

    @Column(name = "[item]")
    private String item;

    @Column(name = "[Content]")
    private String content;

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
     * @return item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item
     */
    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    /**
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}