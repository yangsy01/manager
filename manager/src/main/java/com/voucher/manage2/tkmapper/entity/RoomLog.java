package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[RoomLog]")
public class RoomLog implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Id
    @Column(name = "[RoomGUID]")
    private String roomguid;

    @Column(name = "[ActionDate]")
    private Date actiondate;

    @Column(name = "[ActionType]")
    private String actiontype;

    @Column(name = "[Operator]")
    private String operator;

    @Column(name = "[LogDate]")
    private Date logdate;

    @Column(name = "[IsFile]")
    private String isfile;

    @Column(name = "[FileParentGUID]")
    private String fileparentguid;

    @Column(name = "[ParentGUID]")
    private String parentguid;

    @Column(name = "[ChartGUID]")
    private String chartguid;

    @Column(name = "[Express]")
    private String express;

    @Column(name = "[Instruction]")
    private String instruction;

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
     * @return ActionDate
     */
    public Date getActiondate() {
        return actiondate;
    }

    /**
     * @param actiondate
     */
    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }

    /**
     * @return ActionType
     */
    public String getActiontype() {
        return actiontype;
    }

    /**
     * @param actiontype
     */
    public void setActiontype(String actiontype) {
        this.actiontype = actiontype == null ? null : actiontype.trim();
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
     * @return LogDate
     */
    public Date getLogdate() {
        return logdate;
    }

    /**
     * @param logdate
     */
    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    /**
     * @return IsFile
     */
    public String getIsfile() {
        return isfile;
    }

    /**
     * @param isfile
     */
    public void setIsfile(String isfile) {
        this.isfile = isfile == null ? null : isfile.trim();
    }

    /**
     * @return FileParentGUID
     */
    public String getFileparentguid() {
        return fileparentguid;
    }

    /**
     * @param fileparentguid
     */
    public void setFileparentguid(String fileparentguid) {
        this.fileparentguid = fileparentguid == null ? null : fileparentguid.trim();
    }

    /**
     * @return ParentGUID
     */
    public String getParentguid() {
        return parentguid;
    }

    /**
     * @param parentguid
     */
    public void setParentguid(String parentguid) {
        this.parentguid = parentguid == null ? null : parentguid.trim();
    }

    /**
     * @return ChartGUID
     */
    public String getChartguid() {
        return chartguid;
    }

    /**
     * @param chartguid
     */
    public void setChartguid(String chartguid) {
        this.chartguid = chartguid == null ? null : chartguid.trim();
    }

    /**
     * @return Express
     */
    public String getExpress() {
        return express;
    }

    /**
     * @param express
     */
    public void setExpress(String express) {
        this.express = express == null ? null : express.trim();
    }

    /**
     * @return Instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @param instruction
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }
}