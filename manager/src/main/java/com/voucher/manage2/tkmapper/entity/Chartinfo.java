package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[ChartInfo]")
public class Chartinfo implements Serializable {
    @Id
    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[HireGUID]")
    private String hireguid;

    @Column(name = "[RoomAddress]")
    private String roomaddress;

    @Column(name = "[Charter]")
    private String charter;         //承租人

    @Column(name = "[ChartType]")
    private String charttype;       //安置类型

    @Column(name = "[CharterProperty]")
    private String charterproperty;             //承租人性质

    @Column(name = "[Sex]")
    private String sex;         //性别

    @Column(name = "[CardType]")
    private String cardtype;         //证件类型

    @Column(name = "[IDNo]")
    private String idno;         //证件号

    @Column(name = "[Corporation]")
    private String corporation;         //法人代表

    @Column(name = "[Phone]")
    private String phone;         //联系电话

    @Column(name = "[HomeAddress]")
    private String homeaddress;         //联系地址

    @Column(name = "[ChartProperty]")
    private String chartproperty;         //租赁性质

    @Column(name = "[ContractNo]")
    private String contractno;         //合同编号

    @Column(name = "[ConcludeDate]")
    private Date concludedate;         //签订日期

    @Column(name = "[ChartBeginDate]")
    private Date chartbegindate;         //合同起始

    @Column(name = "[ChartEndDate]")
    private Date chartenddate;         //合同终止

    @Column(name = "[AssureAmount]")
    private Double assureamount;         //保证金

    @Column(name = "[Hire]")
    private Double hire;         //月租金

    @Column(name = "[ChartCriterion]")
    private Double chartcriterion;         //租赁标准

    @Column(name = "[Area]")
    private Double area;         //计租面积

    @Column(name = "[TotalHire]")
    private Double totalhire;         //合同总额

    @Column(name = "[AddRate]")
    private Double addrate;         //租赁标准后面的 率

    @Column(name = "[AddType]")
    private String addtype;         //

    @Column(name = "[BeginAddDate]")
    private String beginadddate;         //

    @Column(name = "[HireEndDate]")
    private Date hireenddate;         //

    @Column(name = "[AccountBalance]")
    private Double accountbalance;         //

    @Column(name = "[OweHireResion]")
    private String owehireresion;         //欠租原因

    @Column(name = "[CreditRating]")
    private String creditrating;         //信誉等级

    @Column(name = "[FareItem]")
    private String fareitem;         //经营项目

    @Column(name = "[ShopName]")
    private String shopname;         //

    @Column(name = "[LowProtect]")
    private String lowprotect;         //是否低保

    @Column(name = "[CharterCode]")
    private String chartercode;         //

    @Column(name = "[CalculateHireDay]")
    private Integer calculatehireday;         //

    @Column(name = "[Memo]")
    private String memo;         //备注

    @Column(name = "[IsHistory]")
    private Boolean ishistory;         //

    @Column(name = "[Region]")
    private String region;         //所在乡镇

    @Column(name = "[ManageRegion]")
    private String manageregion;         //产权单位

    @Column(name = "[RoomProperty]")
    private String roomproperty;         //房屋性质

    @Column(name = "[Useful]")
    private String useful;         //用途

    @Column(name = "[OriginalUnit]")
    private String originalunit;         //

    @Column(name = "[Segment]")
    private String segment;         //

    @Column(name = "[BelongUnit]")
    private String belongunit;         //所属单位

    @Column(name = "[Operator]")
    private String operator;         //经办人

    @Column(name = "[AgeLimite]")
    private Integer agelimite;         //

    @Column(name = "[IsStopHireIn]")
    private Boolean isstophirein;         //

    @Column(name = "[StopHireInResion]")
    private String stophireinresion;         //暂停收租原因

    @Column(name = "[Manager]")
    private String manager;         //

    @Column(name = "[DangerClassification]")
    private String dangerclassification;         //危房等级

    @Column(name = "[NSRSBH]")
    private String nsrsbh;         //

    @Column(name = "[KHH]")
    private String khh;         //

    @Column(name = "[AddFashion]")
    private String addfashion;         //

    @Column(name = "[PlacementFees]")
    private String placementFees;         //房屋安置费

    @Column(name = "[GasInstallationFees]")
    private String gasInstallationFees;         //天然气安置费


    private static final long serialVersionUID = 1L;

    public String getPlacementFees() {
        return placementFees;
    }

    public void setPlacementFees(String placementFees) {
        this.placementFees = placementFees;
    }

    public String getGasInstallationFees() {
        return gasInstallationFees;
    }

    public void setGasInstallationFees(String gasInstallationFees) {
        this.gasInstallationFees = gasInstallationFees;
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
     * @return HireGUID
     */
    public String getHireguid() {
        return hireguid;
    }

    /**
     * @param hireguid
     */
    public void setHireguid(String hireguid) {
        this.hireguid = hireguid == null ? null : hireguid.trim();
    }

    /**
     * @return RoomAddress
     */
    public String getRoomaddress() {
        return roomaddress;
    }

    /**
     * @param roomaddress
     */
    public void setRoomaddress(String roomaddress) {
        this.roomaddress = roomaddress == null ? null : roomaddress.trim();
    }

    /**
     * @return Charter
     */
    public String getCharter() {
        return charter;
    }

    /**
     * @param charter
     */
    public void setCharter(String charter) {
        this.charter = charter == null ? null : charter.trim();
    }

    /**
     * @return ChartType
     */
    public String getCharttype() {
        return charttype;
    }

    /**
     * @param charttype
     */
    public void setCharttype(String charttype) {
        this.charttype = charttype == null ? null : charttype.trim();
    }

    /**
     * @return CharterProperty
     */
    public String getCharterproperty() {
        return charterproperty;
    }

    /**
     * @param charterproperty
     */
    public void setCharterproperty(String charterproperty) {
        this.charterproperty = charterproperty == null ? null : charterproperty.trim();
    }

    /**
     * @return Sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return CardType
     */
    public String getCardtype() {
        return cardtype;
    }

    /**
     * @param cardtype
     */
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    /**
     * @return IDNo
     */
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno
     */
    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    /**
     * @return Corporation
     */
    public String getCorporation() {
        return corporation;
    }

    /**
     * @param corporation
     */
    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    /**
     * @return Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return HomeAddress
     */
    public String getHomeaddress() {
        return homeaddress;
    }

    /**
     * @param homeaddress
     */
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    /**
     * @return ChartProperty
     */
    public String getChartproperty() {
        return chartproperty;
    }

    /**
     * @param chartproperty
     */
    public void setChartproperty(String chartproperty) {
        this.chartproperty = chartproperty == null ? null : chartproperty.trim();
    }

    /**
     * @return ContractNo
     */
    public String getContractno() {
        return contractno;
    }

    /**
     * @param contractno
     */
    public void setContractno(String contractno) {
        this.contractno = contractno == null ? null : contractno.trim();
    }

    /**
     * @return ConcludeDate
     */
    public Date getConcludedate() {
        return concludedate;
    }

    /**
     * @param concludedate
     */
    public void setConcludedate(Date concludedate) {
        this.concludedate = concludedate;
    }

    /**
     * @return ChartBeginDate
     */
    public Date getChartbegindate() {
        return chartbegindate;
    }

    /**
     * @param chartbegindate
     */
    public void setChartbegindate(Date chartbegindate) {
        this.chartbegindate = chartbegindate;
    }

    /**
     * @return ChartEndDate
     */
    public Date getChartenddate() {
        return chartenddate;
    }

    /**
     * @param chartenddate
     */
    public void setChartenddate(Date chartenddate) {
        this.chartenddate = chartenddate;
    }

    /**
     * @return AssureAmount
     */
    public Double getAssureamount() {
        return assureamount;
    }

    /**
     * @param assureamount
     */
    public void setAssureamount(Double assureamount) {
        this.assureamount = assureamount;
    }

    /**
     * @return Hire
     */
    public Double getHire() {
        return hire;
    }

    /**
     * @param hire
     */
    public void setHire(Double hire) {
        this.hire = hire;
    }

    /**
     * @return ChartCriterion
     */
    public Double getChartcriterion() {
        return chartcriterion;
    }

    /**
     * @param chartcriterion
     */
    public void setChartcriterion(Double chartcriterion) {
        this.chartcriterion = chartcriterion;
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
     * @return TotalHire
     */
    public Double getTotalhire() {
        return totalhire;
    }

    /**
     * @param totalhire
     */
    public void setTotalhire(Double totalhire) {
        this.totalhire = totalhire;
    }

    /**
     * @return AddRate
     */
    public Double getAddrate() {
        return addrate;
    }

    /**
     * @param addrate
     */
    public void setAddrate(Double addrate) {
        this.addrate = addrate;
    }

    /**
     * @return AddType
     */
    public String getAddtype() {
        return addtype;
    }

    /**
     * @param addtype
     */
    public void setAddtype(String addtype) {
        this.addtype = addtype == null ? null : addtype.trim();
    }

    /**
     * @return BeginAddDate
     */
    public String getBeginadddate() {
        return beginadddate;
    }

    /**
     * @param beginadddate
     */
    public void setBeginadddate(String beginadddate) {
        this.beginadddate = beginadddate == null ? null : beginadddate.trim();
    }

    /**
     * @return HireEndDate
     */
    public Date getHireenddate() {
        return hireenddate;
    }

    /**
     * @param hireenddate
     */
    public void setHireenddate(Date hireenddate) {
        this.hireenddate = hireenddate;
    }

    /**
     * @return AccountBalance
     */
    public Double getAccountbalance() {
        return accountbalance;
    }

    /**
     * @param accountbalance
     */
    public void setAccountbalance(Double accountbalance) {
        this.accountbalance = accountbalance;
    }

    /**
     * @return OweHireResion
     */
    public String getOwehireresion() {
        return owehireresion;
    }

    /**
     * @param owehireresion
     */
    public void setOwehireresion(String owehireresion) {
        this.owehireresion = owehireresion == null ? null : owehireresion.trim();
    }

    /**
     * @return CreditRating
     */
    public String getCreditrating() {
        return creditrating;
    }

    /**
     * @param creditrating
     */
    public void setCreditrating(String creditrating) {
        this.creditrating = creditrating == null ? null : creditrating.trim();
    }

    /**
     * @return FareItem
     */
    public String getFareitem() {
        return fareitem;
    }

    /**
     * @param fareitem
     */
    public void setFareitem(String fareitem) {
        this.fareitem = fareitem == null ? null : fareitem.trim();
    }

    /**
     * @return ShopName
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * @param shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    /**
     * @return LowProtect
     */
    public String getLowprotect() {
        return lowprotect;
    }

    /**
     * @param lowprotect
     */
    public void setLowprotect(String lowprotect) {
        this.lowprotect = lowprotect == null ? null : lowprotect.trim();
    }

    /**
     * @return CharterCode
     */
    public String getChartercode() {
        return chartercode;
    }

    /**
     * @param chartercode
     */
    public void setChartercode(String chartercode) {
        this.chartercode = chartercode == null ? null : chartercode.trim();
    }

    /**
     * @return CalculateHireDay
     */
    public Integer getCalculatehireday() {
        return calculatehireday;
    }

    /**
     * @param calculatehireday
     */
    public void setCalculatehireday(Integer calculatehireday) {
        this.calculatehireday = calculatehireday;
    }

    /**
     * @return Memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * @return IsHistory
     */
    public Boolean getIshistory() {
        return ishistory;
    }

    /**
     * @param ishistory
     */
    public void setIshistory(Boolean ishistory) {
        this.ishistory = ishistory;
    }

    /**
     * @return Region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return ManageRegion
     */
    public String getManageregion() {
        return manageregion;
    }

    /**
     * @param manageregion
     */
    public void setManageregion(String manageregion) {
        this.manageregion = manageregion == null ? null : manageregion.trim();
    }

    /**
     * @return RoomProperty
     */
    public String getRoomproperty() {
        return roomproperty;
    }

    /**
     * @param roomproperty
     */
    public void setRoomproperty(String roomproperty) {
        this.roomproperty = roomproperty == null ? null : roomproperty.trim();
    }

    /**
     * @return Useful
     */
    public String getUseful() {
        return useful;
    }

    /**
     * @param useful
     */
    public void setUseful(String useful) {
        this.useful = useful == null ? null : useful.trim();
    }

    /**
     * @return OriginalUnit
     */
    public String getOriginalunit() {
        return originalunit;
    }

    /**
     * @param originalunit
     */
    public void setOriginalunit(String originalunit) {
        this.originalunit = originalunit == null ? null : originalunit.trim();
    }

    /**
     * @return Segment
     */
    public String getSegment() {
        return segment;
    }

    /**
     * @param segment
     */
    public void setSegment(String segment) {
        this.segment = segment == null ? null : segment.trim();
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
     * @return AgeLimite
     */
    public Integer getAgelimite() {
        return agelimite;
    }

    /**
     * @param agelimite
     */
    public void setAgelimite(Integer agelimite) {
        this.agelimite = agelimite;
    }

    /**
     * @return IsStopHireIn
     */
    public Boolean getIsstophirein() {
        return isstophirein;
    }

    /**
     * @param isstophirein
     */
    public void setIsstophirein(Boolean isstophirein) {
        this.isstophirein = isstophirein;
    }

    /**
     * @return StopHireInResion
     */
    public String getStophireinresion() {
        return stophireinresion;
    }

    /**
     * @param stophireinresion
     */
    public void setStophireinresion(String stophireinresion) {
        this.stophireinresion = stophireinresion == null ? null : stophireinresion.trim();
    }

    /**
     * @return Manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param manager
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * @return DangerClassification
     */
    public String getDangerclassification() {
        return dangerclassification;
    }

    /**
     * @param dangerclassification
     */
    public void setDangerclassification(String dangerclassification) {
        this.dangerclassification = dangerclassification == null ? null : dangerclassification.trim();
    }

    /**
     * @return NSRSBH
     */
    public String getNsrsbh() {
        return nsrsbh;
    }

    /**
     * @param nsrsbh
     */
    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh == null ? null : nsrsbh.trim();
    }

    /**
     * @return KHH
     */
    public String getKhh() {
        return khh;
    }

    /**
     * @param khh
     */
    public void setKhh(String khh) {
        this.khh = khh == null ? null : khh.trim();
    }

    /**
     * @return AddFashion
     */
    public String getAddfashion() {
        return addfashion;
    }

    /**
     * @param addfashion
     */
    public void setAddfashion(String addfashion) {
        this.addfashion = addfashion == null ? null : addfashion.trim();
    }
}