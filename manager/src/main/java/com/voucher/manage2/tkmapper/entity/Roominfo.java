package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "[RoomInfo]")
public class Roominfo implements Serializable {
    @Override
    public String toString() {
        return "Roominfo{" +
                "guid='" + guid + '\'' +
                ", num='" + num + '\'' +
                ", originalnum='" + originalnum + '\'' +
                ", address='" + address + '\'' +
                ", originaladdress='" + originaladdress + '\'' +
                ", region='" + region + '\'' +
                ", segment='" + segment + '\'' +
                ", manageregion='" + manageregion + '\'' +
                ", roomproperty='" + roomproperty + '\'' +
                ", useful='" + useful + '\'' +
                ", floor='" + floor + '\'' +
                ", state='" + state + '\'' +
                ", structure='" + structure + '\'' +
                ", buildarea=" + buildarea +
                ", roomtype='" + roomtype + '\'' +
                ", iscity='" + iscity + '\'' +
                ", manager='" + manager + '\'' +
                ", managerphone='" + managerphone + '\'' +
                ", isstreet='" + isstreet + '\'' +
                ", fitment='" + fitment + '\'' +
                ", befrom='" + befrom + '\'' +
                ", indate=" + indate +
                ", propertyrightno='" + propertyrightno + '\'' +
                ", propertyrightarea=" + propertyrightarea +
                ", designuseful='" + designuseful + '\'' +
                ", buildyear=" + buildyear +
                ", propertyrightunit='" + propertyrightunit + '\'' +
                ", realpropertyrightunit='" + realpropertyrightunit + '\'' +
                ", propertycardunit='" + propertycardunit + '\'' +
                ", glebecardunit='" + glebecardunit + '\'' +
                ", transferunit='" + transferunit + '\'' +
                ", glebecardno='" + glebecardno + '\'' +
                ", glebeusetype='" + glebeusetype + '\'' +
                ", glebeenddate='" + glebeenddate + '\'' +
                ", glebetypeuseful='" + glebetypeuseful + '\'' +
                ", planuseful='" + planuseful + '\'' +
                ", befromfile='" + befromfile + '\'' +
                ", noprnresion='" + noprnresion + '\'' +
                ", nogcresion='" + nogcresion + '\'' +
                ", realestateno='" + realestateno + '\'' +
                ", propertymemo='" + propertymemo + '\'' +
                ", originalamount=" + originalamount +
                ", alldepreciation=" + alldepreciation +
                ", depreciationyear=" + depreciationyear +
                ", networth=" + networth +
                ", evaluationprice=" + evaluationprice +
                ", evaluationsingleprice=" + evaluationsingleprice +
                ", evaluationplace=" + evaluationplace +
                ", befromamount=" + befromamount +
                ", markethire=" + markethire +
                ", evaluationunit='" + evaluationunit + '\'' +
                ", evaluationno='" + evaluationno + '\'' +
                ", ispawn='" + ispawn + '\'' +
                ", pawnunit='" + pawnunit + '\'' +
                ", originalunit='" + originalunit + '\'' +
                ", financememo='" + financememo + '\'' +
                ", utility='" + utility + '\'' +
                ", chartguid='" + chartguid + '\'' +
                ", addresscode='" + addresscode + '\'' +
                ", originaladdresscode='" + originaladdresscode + '\'' +
                ", securityclassification='" + securityclassification + '\'' +
                ", dangerclassification='" + dangerclassification + '\'' +
                ", hiddendanger='" + hiddendanger + '\'' +
                ", responsibleperson='" + responsibleperson + '\'' +
                ", smemo='" + smemo + '\'' +
                ", belongunit='" + belongunit + '\'' +
                ", fileindex='" + fileindex + '\'' +
                ", securityregion='" + securityregion + '\'' +
                ", roomcount=" + roomcount +
                ", landarea=" + landarea +
                ", useyears=" + useyears +
                ", hiddenCheckDate=" + hiddenCheckDate +
                ", assetCheckDate=" + assetCheckDate +
                ", ishidden=" + ishidden +
                ", neatenFlow=" + neatenFlow +
                ", validstate=" + validstate +
                ", auditingstate='" + auditingstate + '\'' +
                '}';
    }

    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[Num]")     //编号
    private String num;

    @Column(name = "[OriginalNum]")     //原编号
    private String originalnum;

    @Column(name = "[Address]")     //地址
    private String address;

    @Column(name = "[OriginalAddress]")     //原地址
    private String originaladdress;

    @Column(name = "[Region]")
    private String region;          //所在乡镇

    @Column(name = "[Segment]")
    private String segment;     //所在街道

    @Column(name = "[ManageRegion]")
    private String manageregion;    //所在社区

    @Column(name = "[RoomProperty]")
    private String roomproperty;    //房屋性质

    @Column(name = "[Useful]")
    private String useful;      //用途

    @Column(name = "[Floor]")
    private String floor;   //  楼层

    @Column(name = "[State]")
    private String state;   //  状态

    @Column(name = "[Structure]")
    private String structure;   //房屋结构

    @Column(name = "[BuildArea]")
    private Double buildarea;   //建筑面积

    @Column(name = "[RoomType]")
    private String roomtype;   //户型

    @Column(name = "[IsCity]")
    private String iscity;   //是否纠纷

    @Column(name = "[Manager]")
    private String manager;   //房管员

    @Column(name = "[ManagerPhone]")
    private String managerphone;   //联系电话

    @Column(name = "[IsStreet]")
    private String isstreet;   //临街

    @Column(name = "[FitMent]")
    private String fitment;   //装修情况

    @Column(name = "[BeFrom]")
    private String befrom;   //房屋来源

    @Column(name = "[InDate]")
    private Date indate;   //签订日期

    @Column(name = "[PropertyRightNo]")
    private String propertyrightno;   //房产证号

    @Column(name = "[PropertyRightArea]")
    private Double propertyrightarea;   //产权面积

    @Column(name = "[DesignUseful]")
    private String designuseful;   //设计用途

    @Column(name = "[BuildYear]")
    private Integer buildyear;   //建筑年份

    @Column(name = "[PropertyRightUnit]")
    private String propertyrightunit;   //产权单位

    @Column(name = "[RealPropertyRightUnit]")
    private String realpropertyrightunit;   //实际产权单位

    @Column(name = "[PropertyCardUnit]")
    private String propertycardunit;   //房产证证载权属单位

    @Column(name = "[GlebeCardUnit]")
    private String glebecardunit;   //土地证证载权属单位

    @Column(name = "[TransferUnit]")
    private String transferunit;   //移交单位

    @Column(name = "[GlebeCardNo]")
    private String glebecardno;   //土地证号

    @Column(name = "[GlebeUseType]")
    private String glebeusetype;   //使用权类型

    @Column(name = "[GlebeEndDate]")
    private String glebeenddate;   //土地到期年限

    @Column(name = "[GlebeTypeUseful]")
    private String glebetypeuseful;   //地类用途

    @Column(name = "[PlanUseful]")
    private String planuseful;   //规划用途

    @Column(name = "[BefromFile]")
    private String befromfile;   //产权来源文件

    @Column(name = "[NoPRNResion]")
    private String noprnresion;   //

    @Column(name = "[NoGCResion]")
    private String nogcresion;   //

    @Column(name = "[RealEstateNo]")
    private String realestateno;   //川2015泸州市不动产权第0020558号

    @Column(name = "[PropertyMemo]")
    private String propertymemo;   //无证、有证

    @Column(name = "[OriginalAmount]")
    private Double originalamount;   //资产成本

    @Column(name = "[AllDepreciation]")
    private Double alldepreciation;   //累计折旧

    @Column(name = "[DepreciationYear]")
    private Double depreciationyear;   //已提年限

    @Column(name = "[NetWorth]")
    private Double networth;   //资产净值

    @Column(name = "[EvaluationPrice]")
    private Double evaluationprice;   //公允价值

    @Column(name = "[EvaluationSinglePrice]")
    private Double evaluationsingleprice;   //资产单价

    @Column(name = "[EvaluationPlace]")
    private Date evaluationplace;   //评估时间

    @Column(name = "[BefromAmount]")
    private Double befromamount;   //历史来源价值

    @Column(name = "[MarketHire]")
    private Double markethire;   //市场租金

    @Column(name = "[EvaluationUnit]")
    private String evaluationunit;   //评估机构

    @Column(name = "[EvaluationNo]")
    private String evaluationno;   //评估号

    @Column(name = "[IsPawn]")
    private String ispawn;   //是否抵押

    @Column(name = "[PawnUnit]")
    private String pawnunit;   //抵押单位

    @Column(name = "[OriginalUnit]")
    private String originalunit;   //代管资产原所属单位

    @Column(name = "[FinanceMemo]")
    private String financememo;   //财务备注

    @Column(name = "[Utility]")
    private String utility;   //纠纷原因

    @Column(name = "[ChartGUID]")
    private String chartguid;   //合同ID

    @Column(name = "[AddressCode]")
    private String addresscode;   //

    @Column(name = "[OriginalAddressCode]")
    private String originaladdresscode;   //

    @Column(name = "[SecurityClassification]")
    private String securityclassification;   //完好等级

    @Column(name = "[DangerClassification]")
    private String dangerclassification;   //危房等级

    @Column(name = "[HiddenDanger]")
    private String hiddendanger;   //安全隐患等级

    @Column(name = "[ResponsiblePerson]")
    private String responsibleperson;   //安全负责人

    @Column(name = "[sMemo]")
    private String smemo;   //备注信息

    @Column(name = "[BelongUnit]")
    private String belongunit;   //

    @Column(name = "[FileIndex]")
    private String fileindex;   //

    @Column(name = "[SecurityRegion]")
    private String securityregion;   //资产分类

    @Column(name = "[RoomCount]")
    private Integer roomcount;   //

    @Column(name = "[LandArea]")
    private Double landarea;   //土地证面积

    @Column(name = "[UseYears]")
    private Double useyears;   //

    @Column(name = "[hidden_check_date]")
    private Date hiddenCheckDate;   //资产巡查日期

    @Column(name = "[asset_check_date]")
    private Date assetCheckDate;   //资产检查日期

    @Column(name = "[IsHidden]")
    private Integer ishidden;   //

    @Column(name = "[neaten_flow]")
    private Integer neatenFlow;   //

    @Column(name = "[ValidState]")
    private Integer validstate;   //

    @Column(name = "[AuditingState]")
    private String auditingstate;   //

    @Column(name = "[TenementInfo]")
    private String tenementInfo;   //物业信息板块

    public String getTenementInfo() {
        return tenementInfo;
    }

    public void setTenementInfo(String tenementInfo) {
        this.tenementInfo = tenementInfo;
    }

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
     * @return Num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * @return OriginalNum
     */
    public String getOriginalnum() {
        return originalnum;
    }

    /**
     * @param originalnum
     */
    public void setOriginalnum(String originalnum) {
        this.originalnum = originalnum == null ? null : originalnum.trim();
    }

    /**
     * @return Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return OriginalAddress
     */
    public String getOriginaladdress() {
        return originaladdress;
    }

    /**
     * @param originaladdress
     */
    public void setOriginaladdress(String originaladdress) {
        this.originaladdress = originaladdress == null ? null : originaladdress.trim();
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
     * @return Floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor
     */
    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    /**
     * @return State
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return Structure
     */
    public String getStructure() {
        return structure;
    }

    /**
     * @param structure
     */
    public void setStructure(String structure) {
        this.structure = structure == null ? null : structure.trim();
    }

    /**
     * @return BuildArea
     */
    public Double getBuildarea() {
        return buildarea;
    }

    /**
     * @param buildarea
     */
    public void setBuildarea(Double buildarea) {
        this.buildarea = buildarea;
    }

    /**
     * @return RoomType
     */
    public String getRoomtype() {
        return roomtype;
    }

    /**
     * @param roomtype
     */
    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    /**
     * @return IsCity
     */
    public String getIscity() {
        return iscity;
    }

    /**
     * @param iscity
     */
    public void setIscity(String iscity) {
        this.iscity = iscity == null ? null : iscity.trim();
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
     * @return ManagerPhone
     */
    public String getManagerphone() {
        return managerphone;
    }

    /**
     * @param managerphone
     */
    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone == null ? null : managerphone.trim();
    }

    /**
     * @return IsStreet
     */
    public String getIsstreet() {
        return isstreet;
    }

    /**
     * @param isstreet
     */
    public void setIsstreet(String isstreet) {
        this.isstreet = isstreet == null ? null : isstreet.trim();
    }

    /**
     * @return FitMent
     */
    public String getFitment() {
        return fitment;
    }

    /**
     * @param fitment
     */
    public void setFitment(String fitment) {
        this.fitment = fitment == null ? null : fitment.trim();
    }

    /**
     * @return BeFrom
     */
    public String getBefrom() {
        return befrom;
    }

    /**
     * @param befrom
     */
    public void setBefrom(String befrom) {
        this.befrom = befrom == null ? null : befrom.trim();
    }

    /**
     * @return InDate
     */
    public Date getIndate() {
        return indate;
    }

    /**
     * @param indate
     */
    public void setIndate(Date indate) {
        this.indate = indate;
    }

    /**
     * @return PropertyRightNo
     */
    public String getPropertyrightno() {
        return propertyrightno;
    }

    /**
     * @param propertyrightno
     */
    public void setPropertyrightno(String propertyrightno) {
        this.propertyrightno = propertyrightno == null ? null : propertyrightno.trim();
    }

    /**
     * @return PropertyRightArea
     */
    public Double getPropertyrightarea() {
        return propertyrightarea;
    }

    /**
     * @param propertyrightarea
     */
    public void setPropertyrightarea(Double propertyrightarea) {
        this.propertyrightarea = propertyrightarea;
    }

    /**
     * @return DesignUseful
     */
    public String getDesignuseful() {
        return designuseful;
    }

    /**
     * @param designuseful
     */
    public void setDesignuseful(String designuseful) {
        this.designuseful = designuseful == null ? null : designuseful.trim();
    }

    /**
     * @return BuildYear
     */
    public Integer getBuildyear() {
        return buildyear;
    }

    /**
     * @param buildyear
     */
    public void setBuildyear(Integer buildyear) {
        this.buildyear = buildyear;
    }

    /**
     * @return PropertyRightUnit
     */
    public String getPropertyrightunit() {
        return propertyrightunit;
    }

    /**
     * @param propertyrightunit
     */
    public void setPropertyrightunit(String propertyrightunit) {
        this.propertyrightunit = propertyrightunit == null ? null : propertyrightunit.trim();
    }

    /**
     * @return RealPropertyRightUnit
     */
    public String getRealpropertyrightunit() {
        return realpropertyrightunit;
    }

    /**
     * @param realpropertyrightunit
     */
    public void setRealpropertyrightunit(String realpropertyrightunit) {
        this.realpropertyrightunit = realpropertyrightunit == null ? null : realpropertyrightunit.trim();
    }

    /**
     * @return PropertyCardUnit
     */
    public String getPropertycardunit() {
        return propertycardunit;
    }

    /**
     * @param propertycardunit
     */
    public void setPropertycardunit(String propertycardunit) {
        this.propertycardunit = propertycardunit == null ? null : propertycardunit.trim();
    }

    /**
     * @return GlebeCardUnit
     */
    public String getGlebecardunit() {
        return glebecardunit;
    }

    /**
     * @param glebecardunit
     */
    public void setGlebecardunit(String glebecardunit) {
        this.glebecardunit = glebecardunit == null ? null : glebecardunit.trim();
    }

    /**
     * @return TransferUnit
     */
    public String getTransferunit() {
        return transferunit;
    }

    /**
     * @param transferunit
     */
    public void setTransferunit(String transferunit) {
        this.transferunit = transferunit == null ? null : transferunit.trim();
    }

    /**
     * @return GlebeCardNo
     */
    public String getGlebecardno() {
        return glebecardno;
    }

    /**
     * @param glebecardno
     */
    public void setGlebecardno(String glebecardno) {
        this.glebecardno = glebecardno == null ? null : glebecardno.trim();
    }

    /**
     * @return GlebeUseType
     */
    public String getGlebeusetype() {
        return glebeusetype;
    }

    /**
     * @param glebeusetype
     */
    public void setGlebeusetype(String glebeusetype) {
        this.glebeusetype = glebeusetype == null ? null : glebeusetype.trim();
    }

    /**
     * @return GlebeEndDate
     */
    public String getGlebeenddate() {
        return glebeenddate;
    }

    /**
     * @param glebeenddate
     */
    public void setGlebeenddate(String glebeenddate) {
        this.glebeenddate = glebeenddate == null ? null : glebeenddate.trim();
    }

    /**
     * @return GlebeTypeUseful
     */
    public String getGlebetypeuseful() {
        return glebetypeuseful;
    }

    /**
     * @param glebetypeuseful
     */
    public void setGlebetypeuseful(String glebetypeuseful) {
        this.glebetypeuseful = glebetypeuseful == null ? null : glebetypeuseful.trim();
    }

    /**
     * @return PlanUseful
     */
    public String getPlanuseful() {
        return planuseful;
    }

    /**
     * @param planuseful
     */
    public void setPlanuseful(String planuseful) {
        this.planuseful = planuseful == null ? null : planuseful.trim();
    }

    /**
     * @return BefromFile
     */
    public String getBefromfile() {
        return befromfile;
    }

    /**
     * @param befromfile
     */
    public void setBefromfile(String befromfile) {
        this.befromfile = befromfile == null ? null : befromfile.trim();
    }

    /**
     * @return NoPRNResion
     */
    public String getNoprnresion() {
        return noprnresion;
    }

    /**
     * @param noprnresion
     */
    public void setNoprnresion(String noprnresion) {
        this.noprnresion = noprnresion == null ? null : noprnresion.trim();
    }

    /**
     * @return NoGCResion
     */
    public String getNogcresion() {
        return nogcresion;
    }

    /**
     * @param nogcresion
     */
    public void setNogcresion(String nogcresion) {
        this.nogcresion = nogcresion == null ? null : nogcresion.trim();
    }

    /**
     * @return RealEstateNo
     */
    public String getRealestateno() {
        return realestateno;
    }

    /**
     * @param realestateno
     */
    public void setRealestateno(String realestateno) {
        this.realestateno = realestateno == null ? null : realestateno.trim();
    }

    /**
     * @return PropertyMemo
     */
    public String getPropertymemo() {
        return propertymemo;
    }

    /**
     * @param propertymemo
     */
    public void setPropertymemo(String propertymemo) {
        this.propertymemo = propertymemo == null ? null : propertymemo.trim();
    }

    /**
     * @return OriginalAmount
     */
    public Double getOriginalamount() {
        return originalamount;
    }

    /**
     * @param originalamount
     */
    public void setOriginalamount(Double originalamount) {
        this.originalamount = originalamount;
    }

    /**
     * @return AllDepreciation
     */
    public Double getAlldepreciation() {
        return alldepreciation;
    }

    /**
     * @param alldepreciation
     */
    public void setAlldepreciation(Double alldepreciation) {
        this.alldepreciation = alldepreciation;
    }

    /**
     * @return DepreciationYear
     */
    public Double getDepreciationyear() {
        return depreciationyear;
    }

    /**
     * @param depreciationyear
     */
    public void setDepreciationyear(Double depreciationyear) {
        this.depreciationyear = depreciationyear;
    }

    /**
     * @return NetWorth
     */
    public Double getNetworth() {
        return networth;
    }

    /**
     * @param networth
     */
    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    /**
     * @return EvaluationPrice
     */
    public Double getEvaluationprice() {
        return evaluationprice;
    }

    /**
     * @param evaluationprice
     */
    public void setEvaluationprice(Double evaluationprice) {
        this.evaluationprice = evaluationprice;
    }

    /**
     * @return EvaluationSinglePrice
     */
    public Double getEvaluationsingleprice() {
        return evaluationsingleprice;
    }

    /**
     * @param evaluationsingleprice
     */
    public void setEvaluationsingleprice(Double evaluationsingleprice) {
        this.evaluationsingleprice = evaluationsingleprice;
    }

    /**
     * @return EvaluationPlace
     */
    public Date getEvaluationplace() {
        return evaluationplace;
    }

    /**
     * @param evaluationplace
     */
    public void setEvaluationplace(Date evaluationplace) {
        this.evaluationplace = evaluationplace;
    }

    /**
     * @return BefromAmount
     */
    public Double getBefromamount() {
        return befromamount;
    }

    /**
     * @param befromamount
     */
    public void setBefromamount(Double befromamount) {
        this.befromamount = befromamount;
    }

    /**
     * @return MarketHire
     */
    public Double getMarkethire() {
        return markethire;
    }

    /**
     * @param markethire
     */
    public void setMarkethire(Double markethire) {
        this.markethire = markethire;
    }

    /**
     * @return EvaluationUnit
     */
    public String getEvaluationunit() {
        return evaluationunit;
    }

    /**
     * @param evaluationunit
     */
    public void setEvaluationunit(String evaluationunit) {
        this.evaluationunit = evaluationunit == null ? null : evaluationunit.trim();
    }

    /**
     * @return EvaluationNo
     */
    public String getEvaluationno() {
        return evaluationno;
    }

    /**
     * @param evaluationno
     */
    public void setEvaluationno(String evaluationno) {
        this.evaluationno = evaluationno == null ? null : evaluationno.trim();
    }

    /**
     * @return IsPawn
     */
    public String getIspawn() {
        return ispawn;
    }

    /**
     * @param ispawn
     */
    public void setIspawn(String ispawn) {
        this.ispawn = ispawn == null ? null : ispawn.trim();
    }

    /**
     * @return PawnUnit
     */
    public String getPawnunit() {
        return pawnunit;
    }

    /**
     * @param pawnunit
     */
    public void setPawnunit(String pawnunit) {
        this.pawnunit = pawnunit == null ? null : pawnunit.trim();
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
     * @return FinanceMemo
     */
    public String getFinancememo() {
        return financememo;
    }

    /**
     * @param financememo
     */
    public void setFinancememo(String financememo) {
        this.financememo = financememo == null ? null : financememo.trim();
    }

    /**
     * @return Utility
     */
    public String getUtility() {
        return utility;
    }

    /**
     * @param utility
     */
    public void setUtility(String utility) {
        this.utility = utility == null ? null : utility.trim();
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
     * @return AddressCode
     */
    public String getAddresscode() {
        return addresscode;
    }

    /**
     * @param addresscode
     */
    public void setAddresscode(String addresscode) {
        this.addresscode = addresscode == null ? null : addresscode.trim();
    }

    /**
     * @return OriginalAddressCode
     */
    public String getOriginaladdresscode() {
        return originaladdresscode;
    }

    /**
     * @param originaladdresscode
     */
    public void setOriginaladdresscode(String originaladdresscode) {
        this.originaladdresscode = originaladdresscode == null ? null : originaladdresscode.trim();
    }

    /**
     * @return SecurityClassification
     */
    public String getSecurityclassification() {
        return securityclassification;
    }

    /**
     * @param securityclassification
     */
    public void setSecurityclassification(String securityclassification) {
        this.securityclassification = securityclassification == null ? null : securityclassification.trim();
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
     * @return HiddenDanger
     */
    public String getHiddendanger() {
        return hiddendanger;
    }

    /**
     * @param hiddendanger
     */
    public void setHiddendanger(String hiddendanger) {
        this.hiddendanger = hiddendanger == null ? null : hiddendanger.trim();
    }

    /**
     * @return ResponsiblePerson
     */
    public String getResponsibleperson() {
        return responsibleperson;
    }

    /**
     * @param responsibleperson
     */
    public void setResponsibleperson(String responsibleperson) {
        this.responsibleperson = responsibleperson == null ? null : responsibleperson.trim();
    }

    /**
     * @return sMemo
     */
    public String getSmemo() {
        return smemo;
    }

    /**
     * @param smemo
     */
    public void setSmemo(String smemo) {
        this.smemo = smemo == null ? null : smemo.trim();
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
     * @return FileIndex
     */
    public String getFileindex() {
        return fileindex;
    }

    /**
     * @param fileindex
     */
    public void setFileindex(String fileindex) {
        this.fileindex = fileindex == null ? null : fileindex.trim();
    }

    /**
     * @return SecurityRegion
     */
    public String getSecurityregion() {
        return securityregion;
    }

    /**
     * @param securityregion
     */
    public void setSecurityregion(String securityregion) {
        this.securityregion = securityregion == null ? null : securityregion.trim();
    }

    /**
     * @return RoomCount
     */
    public Integer getRoomcount() {
        return roomcount;
    }

    /**
     * @param roomcount
     */
    public void setRoomcount(Integer roomcount) {
        this.roomcount = roomcount;
    }

    /**
     * @return LandArea
     */
    public Double getLandarea() {
        return landarea;
    }

    /**
     * @param landarea
     */
    public void setLandarea(Double landarea) {
        this.landarea = landarea;
    }

    /**
     * @return UseYears
     */
    public Double getUseyears() {
        return useyears;
    }

    /**
     * @param useyears
     */
    public void setUseyears(Double useyears) {
        this.useyears = useyears;
    }

    /**
     * @return hidden_check_date
     */
    public Date getHiddenCheckDate() {
        return hiddenCheckDate;
    }

    /**
     * @param hiddenCheckDate
     */
    public void setHiddenCheckDate(Date hiddenCheckDate) {
        this.hiddenCheckDate = hiddenCheckDate;
    }

    /**
     * @return asset_check_date
     */
    public Date getAssetCheckDate() {
        return assetCheckDate;
    }

    /**
     * @param assetCheckDate
     */
    public void setAssetCheckDate(Date assetCheckDate) {
        this.assetCheckDate = assetCheckDate;
    }

    /**
     * @return IsHidden
     */
    public Integer getIshidden() {
        return ishidden;
    }

    /**
     * @param ishidden
     */
    public void setIshidden(Integer ishidden) {
        this.ishidden = ishidden;
    }

    /**
     * @return neaten_flow
     */
    public Integer getNeatenFlow() {
        return neatenFlow;
    }

    /**
     * @param neatenFlow
     */
    public void setNeatenFlow(Integer neatenFlow) {
        this.neatenFlow = neatenFlow;
    }

    /**
     * @return ValidState
     */
    public Integer getValidstate() {
        return validstate;
    }

    /**
     * @param validstate
     */
    public void setValidstate(Integer validstate) {
        this.validstate = validstate;
    }

    /**
     * @return AuditingState
     */
    public String getAuditingstate() {
        return auditingstate;
    }

    /**
     * @param auditingstate
     */
    public void setAuditingstate(String auditingstate) {
        this.auditingstate = auditingstate == null ? null : auditingstate.trim();
    }
}