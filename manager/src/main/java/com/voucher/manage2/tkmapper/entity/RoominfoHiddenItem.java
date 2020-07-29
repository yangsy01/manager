package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[RoomInfo_Hidden_Item]")
public class RoominfoHiddenItem implements Serializable {
    @Column(name = "[guid]")
    private String guid;

    @Column(name = "[fire_extinguisher]")
    private Integer fireExtinguisher;

    @Column(name = "[fire_aging]")
    private Integer fireAging;

    @Column(name = "[high_power]")
    private Integer highPower;

    @Column(name = "[blow]")
    private Integer blow;

    @Column(name = "[line_aging]")
    private Integer lineAging;

    @Column(name = "[wire_chaos]")
    private Integer wireChaos;

    @Column(name = "[valve_aging]")
    private Integer valveAging;

    @Column(name = "[other_fire_hazards]")
    private Integer otherFireHazards;

    @Column(name = "[incline]")
    private Integer incline;

    @Column(name = "[split]")
    private Integer split;

    @Column(name = "[break_off]")
    private Integer breakOff;

    @Column(name = "[destroy]")
    private Integer destroy;

    @Column(name = "[invalidation]")
    private Integer invalidation;

    @Column(name = "[collapse]")
    private Integer collapse;

    @Column(name = "[flaw]")
    private Integer flaw;

    @Column(name = "[cesspool]")
    private Integer cesspool;

    @Column(name = "[wall_up]")
    private Integer wallUp;

    @Column(name = "[secure_channel]")
    private Integer secureChannel;

    @Column(name = "[warning_missing]")
    private Integer warningMissing;

    @Column(name = "[handrail_destroy]")
    private Integer handrailDestroy;

    @Column(name = "[other_supporting]")
    private Integer otherSupporting;

    @Column(name = "[flooding]")
    private Integer flooding;

    @Column(name = "[coast]")
    private Integer coast;

    @Column(name = "[earthquake]")
    private Integer earthquake;

    @Column(name = "[down]")
    private Integer down;

    @Column(name = "[snow]")
    private Integer snow;

    @Column(name = "[other_natural]")
    private Integer otherNatural;

    @Column(name = "[illegal_building]")
    private Integer illegalBuilding;

    @Column(name = "[structural_failure]")
    private Integer structuralFailure;

    @Column(name = "[other_illegal]")
    private Integer otherIllegal;

    @Column(name = "[is_other]")
    private Integer isOther;

    @Column(name = "[other]")
    private String other;

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
     * @return fire_extinguisher
     */
    public Integer getFireExtinguisher() {
        return fireExtinguisher;
    }

    /**
     * @param fireExtinguisher
     */
    public void setFireExtinguisher(Integer fireExtinguisher) {
        this.fireExtinguisher = fireExtinguisher;
    }

    /**
     * @return fire_aging
     */
    public Integer getFireAging() {
        return fireAging;
    }

    /**
     * @param fireAging
     */
    public void setFireAging(Integer fireAging) {
        this.fireAging = fireAging;
    }

    /**
     * @return high_power
     */
    public Integer getHighPower() {
        return highPower;
    }

    /**
     * @param highPower
     */
    public void setHighPower(Integer highPower) {
        this.highPower = highPower;
    }

    /**
     * @return blow
     */
    public Integer getBlow() {
        return blow;
    }

    /**
     * @param blow
     */
    public void setBlow(Integer blow) {
        this.blow = blow;
    }

    /**
     * @return line_aging
     */
    public Integer getLineAging() {
        return lineAging;
    }

    /**
     * @param lineAging
     */
    public void setLineAging(Integer lineAging) {
        this.lineAging = lineAging;
    }

    /**
     * @return wire_chaos
     */
    public Integer getWireChaos() {
        return wireChaos;
    }

    /**
     * @param wireChaos
     */
    public void setWireChaos(Integer wireChaos) {
        this.wireChaos = wireChaos;
    }

    /**
     * @return valve_aging
     */
    public Integer getValveAging() {
        return valveAging;
    }

    /**
     * @param valveAging
     */
    public void setValveAging(Integer valveAging) {
        this.valveAging = valveAging;
    }

    /**
     * @return other_fire_hazards
     */
    public Integer getOtherFireHazards() {
        return otherFireHazards;
    }

    /**
     * @param otherFireHazards
     */
    public void setOtherFireHazards(Integer otherFireHazards) {
        this.otherFireHazards = otherFireHazards;
    }

    /**
     * @return incline
     */
    public Integer getIncline() {
        return incline;
    }

    /**
     * @param incline
     */
    public void setIncline(Integer incline) {
        this.incline = incline;
    }

    /**
     * @return split
     */
    public Integer getSplit() {
        return split;
    }

    /**
     * @param split
     */
    public void setSplit(Integer split) {
        this.split = split;
    }

    /**
     * @return break_off
     */
    public Integer getBreakOff() {
        return breakOff;
    }

    /**
     * @param breakOff
     */
    public void setBreakOff(Integer breakOff) {
        this.breakOff = breakOff;
    }

    /**
     * @return destroy
     */
    public Integer getDestroy() {
        return destroy;
    }

    /**
     * @param destroy
     */
    public void setDestroy(Integer destroy) {
        this.destroy = destroy;
    }

    /**
     * @return invalidation
     */
    public Integer getInvalidation() {
        return invalidation;
    }

    /**
     * @param invalidation
     */
    public void setInvalidation(Integer invalidation) {
        this.invalidation = invalidation;
    }

    /**
     * @return collapse
     */
    public Integer getCollapse() {
        return collapse;
    }

    /**
     * @param collapse
     */
    public void setCollapse(Integer collapse) {
        this.collapse = collapse;
    }

    /**
     * @return flaw
     */
    public Integer getFlaw() {
        return flaw;
    }

    /**
     * @param flaw
     */
    public void setFlaw(Integer flaw) {
        this.flaw = flaw;
    }

    /**
     * @return cesspool
     */
    public Integer getCesspool() {
        return cesspool;
    }

    /**
     * @param cesspool
     */
    public void setCesspool(Integer cesspool) {
        this.cesspool = cesspool;
    }

    /**
     * @return wall_up
     */
    public Integer getWallUp() {
        return wallUp;
    }

    /**
     * @param wallUp
     */
    public void setWallUp(Integer wallUp) {
        this.wallUp = wallUp;
    }

    /**
     * @return secure_channel
     */
    public Integer getSecureChannel() {
        return secureChannel;
    }

    /**
     * @param secureChannel
     */
    public void setSecureChannel(Integer secureChannel) {
        this.secureChannel = secureChannel;
    }

    /**
     * @return warning_missing
     */
    public Integer getWarningMissing() {
        return warningMissing;
    }

    /**
     * @param warningMissing
     */
    public void setWarningMissing(Integer warningMissing) {
        this.warningMissing = warningMissing;
    }

    /**
     * @return handrail_destroy
     */
    public Integer getHandrailDestroy() {
        return handrailDestroy;
    }

    /**
     * @param handrailDestroy
     */
    public void setHandrailDestroy(Integer handrailDestroy) {
        this.handrailDestroy = handrailDestroy;
    }

    /**
     * @return other_supporting
     */
    public Integer getOtherSupporting() {
        return otherSupporting;
    }

    /**
     * @param otherSupporting
     */
    public void setOtherSupporting(Integer otherSupporting) {
        this.otherSupporting = otherSupporting;
    }

    /**
     * @return flooding
     */
    public Integer getFlooding() {
        return flooding;
    }

    /**
     * @param flooding
     */
    public void setFlooding(Integer flooding) {
        this.flooding = flooding;
    }

    /**
     * @return coast
     */
    public Integer getCoast() {
        return coast;
    }

    /**
     * @param coast
     */
    public void setCoast(Integer coast) {
        this.coast = coast;
    }

    /**
     * @return earthquake
     */
    public Integer getEarthquake() {
        return earthquake;
    }

    /**
     * @param earthquake
     */
    public void setEarthquake(Integer earthquake) {
        this.earthquake = earthquake;
    }

    /**
     * @return down
     */
    public Integer getDown() {
        return down;
    }

    /**
     * @param down
     */
    public void setDown(Integer down) {
        this.down = down;
    }

    /**
     * @return snow
     */
    public Integer getSnow() {
        return snow;
    }

    /**
     * @param snow
     */
    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    /**
     * @return other_natural
     */
    public Integer getOtherNatural() {
        return otherNatural;
    }

    /**
     * @param otherNatural
     */
    public void setOtherNatural(Integer otherNatural) {
        this.otherNatural = otherNatural;
    }

    /**
     * @return illegal_building
     */
    public Integer getIllegalBuilding() {
        return illegalBuilding;
    }

    /**
     * @param illegalBuilding
     */
    public void setIllegalBuilding(Integer illegalBuilding) {
        this.illegalBuilding = illegalBuilding;
    }

    /**
     * @return structural_failure
     */
    public Integer getStructuralFailure() {
        return structuralFailure;
    }

    /**
     * @param structuralFailure
     */
    public void setStructuralFailure(Integer structuralFailure) {
        this.structuralFailure = structuralFailure;
    }

    /**
     * @return other_illegal
     */
    public Integer getOtherIllegal() {
        return otherIllegal;
    }

    /**
     * @param otherIllegal
     */
    public void setOtherIllegal(Integer otherIllegal) {
        this.otherIllegal = otherIllegal;
    }

    /**
     * @return is_other
     */
    public Integer getIsOther() {
        return isOther;
    }

    /**
     * @param isOther
     */
    public void setIsOther(Integer isOther) {
        this.isOther = isOther;
    }

    /**
     * @return other
     */
    public String getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}