package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[FileSelfBelong]")
public class Fileselfbelong implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[RoomGUID]")
    private String roomguid;

    @Column(name = "[UpFileFullName]")
    private String upfilefullname;

    @Column(name = "[FileType]")
    private String filetype;

    @Column(name = "[FileBelong]")
    private String filebelong;

    @Column(name = "[FileIndex]")
    private Integer fileindex;

    @Column(name = "[ViewFileName]")
    private String viewfilename;

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
     * @return UpFileFullName
     */
    public String getUpfilefullname() {
        return upfilefullname;
    }

    /**
     * @param upfilefullname
     */
    public void setUpfilefullname(String upfilefullname) {
        this.upfilefullname = upfilefullname == null ? null : upfilefullname.trim();
    }

    /**
     * @return FileType
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * @param filetype
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
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

    /**
     * @return ViewFileName
     */
    public String getViewfilename() {
        return viewfilename;
    }

    /**
     * @param viewfilename
     */
    public void setViewfilename(String viewfilename) {
        this.viewfilename = viewfilename == null ? null : viewfilename.trim();
    }
}