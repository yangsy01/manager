package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "[Role]")
public class Role implements Serializable {
    @Id
    @Column(name = "[RoleName]")
    private String rolename;

    @Id
    @Column(name = "[BelongUnit]")
    private String belongunit;

    @Column(name = "[GUID]")
    private String guid;

    @Column(name = "[ViewList]")
    private String viewlist;

    @Column(name = "[AllList]")
    private Boolean alllist;

    @Column(name = "[SystemManage]")
    private Boolean systemmanage;

    @Column(name = "[systempara]")
    private Boolean systempara;

    @Column(name = "[RoleManage]")
    private Boolean rolemanage;

    @Column(name = "[usermanage]")
    private Boolean usermanage;

    @Column(name = "[dictionary]")
    private Boolean dictionary;

    @Column(name = "[FileRelate]")
    private Boolean filerelate;

    @Column(name = "[SysLog]")
    private Boolean syslog;

    @Column(name = "[RoomBaseData]")
    private Boolean roombasedata;

    @Column(name = "[addroom]")
    private Boolean addroom;

    @Column(name = "[updateroom]")
    private Boolean updateroom;

    @Column(name = "[delroom]")
    private Boolean delroom;

    @Column(name = "[updateChartInfo]")
    private Boolean updatechartinfo;

    @Column(name = "[EditOweHire]")
    private Boolean editowehire;

    @Column(name = "[BussinessOpt]")
    private Boolean bussinessopt;

    @Column(name = "[chart]")
    private Boolean chart;

    @Column(name = "[Relet]")
    private Boolean relet;

    @Column(name = "[HireIn]")
    private Boolean hirein;

    @Column(name = "[exitchart]")
    private Boolean exitchart;

    @Column(name = "[changehire]")
    private Boolean changehire;

    @Column(name = "[changename]")
    private Boolean changename;

    @Column(name = "[UnChangeName]")
    private Boolean unchangename;

    @Column(name = "[Pawn]")
    private Boolean pawn;

    @Column(name = "[CancelPawn]")
    private Boolean cancelpawn;

    @Column(name = "[repairmanage]")
    private Boolean repairmanage;

    @Column(name = "[RoomPropertyDecrease]")
    private Boolean roompropertydecrease;

    @Column(name = "[backout]")
    private Boolean backout;

    @Column(name = "[sellout]")
    private Boolean sellout;

    @Column(name = "[destory]")
    private Boolean destory;

    @Column(name = "[dispart]")
    private Boolean dispart;

    @Column(name = "[roomover]")
    private Boolean roomover;

    @Column(name = "[RoomFileManage]")
    private Boolean roomfilemanage;

    @Column(name = "[FileAdd]")
    private Boolean fileadd;

    @Column(name = "[FileDelete]")
    private Boolean filedelete;

    @Column(name = "[FilePrint]")
    private Boolean fileprint;

    @Column(name = "[SystemQuery]")
    private Boolean systemquery;

    @Column(name = "[HirelistQuery]")
    private Boolean hirelistquery;

    @Column(name = "[OweHireQuery]")
    private Boolean owehirequery;

    @Column(name = "[roomlog]")
    private Boolean roomlog;

    @Column(name = "[RoomPrAdd]")
    private Boolean roompradd;

    @Column(name = "[RoomPrDecrease]")
    private Boolean roomprdecrease;

    @Column(name = "[roomrepairquery]")
    private Boolean roomrepairquery;

    @Column(name = "[RoomPawn]")
    private Boolean roompawn;

    @Column(name = "[SystemReport]")
    private Boolean systemreport;

    @Column(name = "[detaillist]")
    private Boolean detaillist;

    @Column(name = "[currentstate]")
    private Boolean currentstate;

    @Column(name = "[chartinforeport]")
    private Boolean chartinforeport;

    @Column(name = "[roomcasereport]")
    private Boolean roomcasereport;

    @Column(name = "[Other]")
    private Boolean other;

    @Column(name = "[delroomlog]")
    private Boolean delroomlog;

    @Column(name = "[FloorManage]")
    private Boolean floormanage;

    @Column(name = "[PrintData]")
    private Boolean printdata;

    @Column(name = "[complexquery]")
    private Boolean complexquery;

    @Column(name = "[HireUpdate]")
    private Boolean hireupdate;

    @Column(name = "[roomqchz]")
    private Boolean roomqchz;

    @Column(name = "[roomzcrz]")
    private Boolean roomzcrz;

    @Column(name = "[roomzccz]")
    private Boolean roomzccz;

    @Column(name = "[stophirein]")
    private Boolean stophirein;

    @Column(name = "[beginhirein]")
    private Boolean beginhirein;

    @Column(name = "[changeroomstate]")
    private Boolean changeroomstate;

    @Column(name = "[changefree]")
    private Boolean changefree;

    @Column(name = "[telephonebook]")
    private Boolean telephonebook;

    @Column(name = "[monthhirereport]")
    private Boolean monthhirereport;

    @Column(name = "[yearhirereport]")
    private Boolean yearhirereport;

    @Column(name = "[monthhire]")
    private Boolean monthhire;

    @Column(name = "[backrent]")
    private Boolean backrent;

    @Column(name = "[chartquery]")
    private Boolean chartquery;

    @Column(name = "[hirelisttotal]")
    private Boolean hirelisttotal;

    @Column(name = "[hirephyear]")
    private Boolean hirephyear;

    @Column(name = "[hirelistft]")
    private Boolean hirelistft;

    @Column(name = "[znj]")
    private Boolean znj;

    @Column(name = "[repairyearreport]")
    private Boolean repairyearreport;

    @Column(name = "[repairList]")
    private Boolean repairlist;

    @Column(name = "[propertychecktotal]")
    private Boolean propertychecktotal;

    @Column(name = "[safetychecktotal]")
    private Boolean safetychecktotal;

    @Column(name = "[hiddenquery]")
    private Boolean hiddenquery;

    @Column(name = "[propertylay]")
    private Boolean propertylay;

    @Column(name = "[road]")
    private Boolean road;

    @Column(name = "[depreciation]")
    private Boolean depreciation;

    @Column(name = "[messagecase]")
    private Boolean messagecase;

    @Column(name = "[propertytotal]")
    private Boolean propertytotal;

    @Column(name = "[hidden]")
    private Boolean hidden;

    @Column(name = "[HireManage]")
    private Boolean hiremanage;

    @Column(name = "[LoginView]")
    private Boolean loginview;

    private static final long serialVersionUID = 1L;

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
     * @return ViewList
     */
    public String getViewlist() {
        return viewlist;
    }

    /**
     * @param viewlist
     */
    public void setViewlist(String viewlist) {
        this.viewlist = viewlist == null ? null : viewlist.trim();
    }

    /**
     * @return AllList
     */
    public Boolean getAlllist() {
        return alllist;
    }

    /**
     * @param alllist
     */
    public void setAlllist(Boolean alllist) {
        this.alllist = alllist;
    }

    /**
     * @return SystemManage
     */
    public Boolean getSystemmanage() {
        return systemmanage;
    }

    /**
     * @param systemmanage
     */
    public void setSystemmanage(Boolean systemmanage) {
        this.systemmanage = systemmanage;
    }

    /**
     * @return systempara
     */
    public Boolean getSystempara() {
        return systempara;
    }

    /**
     * @param systempara
     */
    public void setSystempara(Boolean systempara) {
        this.systempara = systempara;
    }

    /**
     * @return RoleManage
     */
    public Boolean getRolemanage() {
        return rolemanage;
    }

    /**
     * @param rolemanage
     */
    public void setRolemanage(Boolean rolemanage) {
        this.rolemanage = rolemanage;
    }

    /**
     * @return usermanage
     */
    public Boolean getUsermanage() {
        return usermanage;
    }

    /**
     * @param usermanage
     */
    public void setUsermanage(Boolean usermanage) {
        this.usermanage = usermanage;
    }

    /**
     * @return dictionary
     */
    public Boolean getDictionary() {
        return dictionary;
    }

    /**
     * @param dictionary
     */
    public void setDictionary(Boolean dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * @return FileRelate
     */
    public Boolean getFilerelate() {
        return filerelate;
    }

    /**
     * @param filerelate
     */
    public void setFilerelate(Boolean filerelate) {
        this.filerelate = filerelate;
    }

    /**
     * @return SysLog
     */
    public Boolean getSyslog() {
        return syslog;
    }

    /**
     * @param syslog
     */
    public void setSyslog(Boolean syslog) {
        this.syslog = syslog;
    }

    /**
     * @return RoomBaseData
     */
    public Boolean getRoombasedata() {
        return roombasedata;
    }

    /**
     * @param roombasedata
     */
    public void setRoombasedata(Boolean roombasedata) {
        this.roombasedata = roombasedata;
    }

    /**
     * @return addroom
     */
    public Boolean getAddroom() {
        return addroom;
    }

    /**
     * @param addroom
     */
    public void setAddroom(Boolean addroom) {
        this.addroom = addroom;
    }

    /**
     * @return updateroom
     */
    public Boolean getUpdateroom() {
        return updateroom;
    }

    /**
     * @param updateroom
     */
    public void setUpdateroom(Boolean updateroom) {
        this.updateroom = updateroom;
    }

    /**
     * @return delroom
     */
    public Boolean getDelroom() {
        return delroom;
    }

    /**
     * @param delroom
     */
    public void setDelroom(Boolean delroom) {
        this.delroom = delroom;
    }

    /**
     * @return updateChartInfo
     */
    public Boolean getUpdatechartinfo() {
        return updatechartinfo;
    }

    /**
     * @param updatechartinfo
     */
    public void setUpdatechartinfo(Boolean updatechartinfo) {
        this.updatechartinfo = updatechartinfo;
    }

    /**
     * @return EditOweHire
     */
    public Boolean getEditowehire() {
        return editowehire;
    }

    /**
     * @param editowehire
     */
    public void setEditowehire(Boolean editowehire) {
        this.editowehire = editowehire;
    }

    /**
     * @return BussinessOpt
     */
    public Boolean getBussinessopt() {
        return bussinessopt;
    }

    /**
     * @param bussinessopt
     */
    public void setBussinessopt(Boolean bussinessopt) {
        this.bussinessopt = bussinessopt;
    }

    /**
     * @return chart
     */
    public Boolean getChart() {
        return chart;
    }

    /**
     * @param chart
     */
    public void setChart(Boolean chart) {
        this.chart = chart;
    }

    /**
     * @return Relet
     */
    public Boolean getRelet() {
        return relet;
    }

    /**
     * @param relet
     */
    public void setRelet(Boolean relet) {
        this.relet = relet;
    }

    /**
     * @return HireIn
     */
    public Boolean getHirein() {
        return hirein;
    }

    /**
     * @param hirein
     */
    public void setHirein(Boolean hirein) {
        this.hirein = hirein;
    }

    /**
     * @return exitchart
     */
    public Boolean getExitchart() {
        return exitchart;
    }

    /**
     * @param exitchart
     */
    public void setExitchart(Boolean exitchart) {
        this.exitchart = exitchart;
    }

    /**
     * @return changehire
     */
    public Boolean getChangehire() {
        return changehire;
    }

    /**
     * @param changehire
     */
    public void setChangehire(Boolean changehire) {
        this.changehire = changehire;
    }

    /**
     * @return changename
     */
    public Boolean getChangename() {
        return changename;
    }

    /**
     * @param changename
     */
    public void setChangename(Boolean changename) {
        this.changename = changename;
    }

    /**
     * @return UnChangeName
     */
    public Boolean getUnchangename() {
        return unchangename;
    }

    /**
     * @param unchangename
     */
    public void setUnchangename(Boolean unchangename) {
        this.unchangename = unchangename;
    }

    /**
     * @return Pawn
     */
    public Boolean getPawn() {
        return pawn;
    }

    /**
     * @param pawn
     */
    public void setPawn(Boolean pawn) {
        this.pawn = pawn;
    }

    /**
     * @return CancelPawn
     */
    public Boolean getCancelpawn() {
        return cancelpawn;
    }

    /**
     * @param cancelpawn
     */
    public void setCancelpawn(Boolean cancelpawn) {
        this.cancelpawn = cancelpawn;
    }

    /**
     * @return repairmanage
     */
    public Boolean getRepairmanage() {
        return repairmanage;
    }

    /**
     * @param repairmanage
     */
    public void setRepairmanage(Boolean repairmanage) {
        this.repairmanage = repairmanage;
    }

    /**
     * @return RoomPropertyDecrease
     */
    public Boolean getRoompropertydecrease() {
        return roompropertydecrease;
    }

    /**
     * @param roompropertydecrease
     */
    public void setRoompropertydecrease(Boolean roompropertydecrease) {
        this.roompropertydecrease = roompropertydecrease;
    }

    /**
     * @return backout
     */
    public Boolean getBackout() {
        return backout;
    }

    /**
     * @param backout
     */
    public void setBackout(Boolean backout) {
        this.backout = backout;
    }

    /**
     * @return sellout
     */
    public Boolean getSellout() {
        return sellout;
    }

    /**
     * @param sellout
     */
    public void setSellout(Boolean sellout) {
        this.sellout = sellout;
    }

    /**
     * @return destory
     */
    public Boolean getDestory() {
        return destory;
    }

    /**
     * @param destory
     */
    public void setDestory(Boolean destory) {
        this.destory = destory;
    }

    /**
     * @return dispart
     */
    public Boolean getDispart() {
        return dispart;
    }

    /**
     * @param dispart
     */
    public void setDispart(Boolean dispart) {
        this.dispart = dispart;
    }

    /**
     * @return roomover
     */
    public Boolean getRoomover() {
        return roomover;
    }

    /**
     * @param roomover
     */
    public void setRoomover(Boolean roomover) {
        this.roomover = roomover;
    }

    /**
     * @return RoomFileManage
     */
    public Boolean getRoomfilemanage() {
        return roomfilemanage;
    }

    /**
     * @param roomfilemanage
     */
    public void setRoomfilemanage(Boolean roomfilemanage) {
        this.roomfilemanage = roomfilemanage;
    }

    /**
     * @return FileAdd
     */
    public Boolean getFileadd() {
        return fileadd;
    }

    /**
     * @param fileadd
     */
    public void setFileadd(Boolean fileadd) {
        this.fileadd = fileadd;
    }

    /**
     * @return FileDelete
     */
    public Boolean getFiledelete() {
        return filedelete;
    }

    /**
     * @param filedelete
     */
    public void setFiledelete(Boolean filedelete) {
        this.filedelete = filedelete;
    }

    /**
     * @return FilePrint
     */
    public Boolean getFileprint() {
        return fileprint;
    }

    /**
     * @param fileprint
     */
    public void setFileprint(Boolean fileprint) {
        this.fileprint = fileprint;
    }

    /**
     * @return SystemQuery
     */
    public Boolean getSystemquery() {
        return systemquery;
    }

    /**
     * @param systemquery
     */
    public void setSystemquery(Boolean systemquery) {
        this.systemquery = systemquery;
    }

    /**
     * @return HirelistQuery
     */
    public Boolean getHirelistquery() {
        return hirelistquery;
    }

    /**
     * @param hirelistquery
     */
    public void setHirelistquery(Boolean hirelistquery) {
        this.hirelistquery = hirelistquery;
    }

    /**
     * @return OweHireQuery
     */
    public Boolean getOwehirequery() {
        return owehirequery;
    }

    /**
     * @param owehirequery
     */
    public void setOwehirequery(Boolean owehirequery) {
        this.owehirequery = owehirequery;
    }

    /**
     * @return roomlog
     */
    public Boolean getRoomlog() {
        return roomlog;
    }

    /**
     * @param roomlog
     */
    public void setRoomlog(Boolean roomlog) {
        this.roomlog = roomlog;
    }

    /**
     * @return RoomPrAdd
     */
    public Boolean getRoompradd() {
        return roompradd;
    }

    /**
     * @param roompradd
     */
    public void setRoompradd(Boolean roompradd) {
        this.roompradd = roompradd;
    }

    /**
     * @return RoomPrDecrease
     */
    public Boolean getRoomprdecrease() {
        return roomprdecrease;
    }

    /**
     * @param roomprdecrease
     */
    public void setRoomprdecrease(Boolean roomprdecrease) {
        this.roomprdecrease = roomprdecrease;
    }

    /**
     * @return roomrepairquery
     */
    public Boolean getRoomrepairquery() {
        return roomrepairquery;
    }

    /**
     * @param roomrepairquery
     */
    public void setRoomrepairquery(Boolean roomrepairquery) {
        this.roomrepairquery = roomrepairquery;
    }

    /**
     * @return RoomPawn
     */
    public Boolean getRoompawn() {
        return roompawn;
    }

    /**
     * @param roompawn
     */
    public void setRoompawn(Boolean roompawn) {
        this.roompawn = roompawn;
    }

    /**
     * @return SystemReport
     */
    public Boolean getSystemreport() {
        return systemreport;
    }

    /**
     * @param systemreport
     */
    public void setSystemreport(Boolean systemreport) {
        this.systemreport = systemreport;
    }

    /**
     * @return detaillist
     */
    public Boolean getDetaillist() {
        return detaillist;
    }

    /**
     * @param detaillist
     */
    public void setDetaillist(Boolean detaillist) {
        this.detaillist = detaillist;
    }

    /**
     * @return currentstate
     */
    public Boolean getCurrentstate() {
        return currentstate;
    }

    /**
     * @param currentstate
     */
    public void setCurrentstate(Boolean currentstate) {
        this.currentstate = currentstate;
    }

    /**
     * @return chartinforeport
     */
    public Boolean getChartinforeport() {
        return chartinforeport;
    }

    /**
     * @param chartinforeport
     */
    public void setChartinforeport(Boolean chartinforeport) {
        this.chartinforeport = chartinforeport;
    }

    /**
     * @return roomcasereport
     */
    public Boolean getRoomcasereport() {
        return roomcasereport;
    }

    /**
     * @param roomcasereport
     */
    public void setRoomcasereport(Boolean roomcasereport) {
        this.roomcasereport = roomcasereport;
    }

    /**
     * @return Other
     */
    public Boolean getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(Boolean other) {
        this.other = other;
    }

    /**
     * @return delroomlog
     */
    public Boolean getDelroomlog() {
        return delroomlog;
    }

    /**
     * @param delroomlog
     */
    public void setDelroomlog(Boolean delroomlog) {
        this.delroomlog = delroomlog;
    }

    /**
     * @return FloorManage
     */
    public Boolean getFloormanage() {
        return floormanage;
    }

    /**
     * @param floormanage
     */
    public void setFloormanage(Boolean floormanage) {
        this.floormanage = floormanage;
    }

    /**
     * @return PrintData
     */
    public Boolean getPrintdata() {
        return printdata;
    }

    /**
     * @param printdata
     */
    public void setPrintdata(Boolean printdata) {
        this.printdata = printdata;
    }

    /**
     * @return complexquery
     */
    public Boolean getComplexquery() {
        return complexquery;
    }

    /**
     * @param complexquery
     */
    public void setComplexquery(Boolean complexquery) {
        this.complexquery = complexquery;
    }

    /**
     * @return HireUpdate
     */
    public Boolean getHireupdate() {
        return hireupdate;
    }

    /**
     * @param hireupdate
     */
    public void setHireupdate(Boolean hireupdate) {
        this.hireupdate = hireupdate;
    }

    /**
     * @return roomqchz
     */
    public Boolean getRoomqchz() {
        return roomqchz;
    }

    /**
     * @param roomqchz
     */
    public void setRoomqchz(Boolean roomqchz) {
        this.roomqchz = roomqchz;
    }

    /**
     * @return roomzcrz
     */
    public Boolean getRoomzcrz() {
        return roomzcrz;
    }

    /**
     * @param roomzcrz
     */
    public void setRoomzcrz(Boolean roomzcrz) {
        this.roomzcrz = roomzcrz;
    }

    /**
     * @return roomzccz
     */
    public Boolean getRoomzccz() {
        return roomzccz;
    }

    /**
     * @param roomzccz
     */
    public void setRoomzccz(Boolean roomzccz) {
        this.roomzccz = roomzccz;
    }

    /**
     * @return stophirein
     */
    public Boolean getStophirein() {
        return stophirein;
    }

    /**
     * @param stophirein
     */
    public void setStophirein(Boolean stophirein) {
        this.stophirein = stophirein;
    }

    /**
     * @return beginhirein
     */
    public Boolean getBeginhirein() {
        return beginhirein;
    }

    /**
     * @param beginhirein
     */
    public void setBeginhirein(Boolean beginhirein) {
        this.beginhirein = beginhirein;
    }

    /**
     * @return changeroomstate
     */
    public Boolean getChangeroomstate() {
        return changeroomstate;
    }

    /**
     * @param changeroomstate
     */
    public void setChangeroomstate(Boolean changeroomstate) {
        this.changeroomstate = changeroomstate;
    }

    /**
     * @return changefree
     */
    public Boolean getChangefree() {
        return changefree;
    }

    /**
     * @param changefree
     */
    public void setChangefree(Boolean changefree) {
        this.changefree = changefree;
    }

    /**
     * @return telephonebook
     */
    public Boolean getTelephonebook() {
        return telephonebook;
    }

    /**
     * @param telephonebook
     */
    public void setTelephonebook(Boolean telephonebook) {
        this.telephonebook = telephonebook;
    }

    /**
     * @return monthhirereport
     */
    public Boolean getMonthhirereport() {
        return monthhirereport;
    }

    /**
     * @param monthhirereport
     */
    public void setMonthhirereport(Boolean monthhirereport) {
        this.monthhirereport = monthhirereport;
    }

    /**
     * @return yearhirereport
     */
    public Boolean getYearhirereport() {
        return yearhirereport;
    }

    /**
     * @param yearhirereport
     */
    public void setYearhirereport(Boolean yearhirereport) {
        this.yearhirereport = yearhirereport;
    }

    /**
     * @return monthhire
     */
    public Boolean getMonthhire() {
        return monthhire;
    }

    /**
     * @param monthhire
     */
    public void setMonthhire(Boolean monthhire) {
        this.monthhire = monthhire;
    }

    /**
     * @return backrent
     */
    public Boolean getBackrent() {
        return backrent;
    }

    /**
     * @param backrent
     */
    public void setBackrent(Boolean backrent) {
        this.backrent = backrent;
    }

    /**
     * @return chartquery
     */
    public Boolean getChartquery() {
        return chartquery;
    }

    /**
     * @param chartquery
     */
    public void setChartquery(Boolean chartquery) {
        this.chartquery = chartquery;
    }

    /**
     * @return hirelisttotal
     */
    public Boolean getHirelisttotal() {
        return hirelisttotal;
    }

    /**
     * @param hirelisttotal
     */
    public void setHirelisttotal(Boolean hirelisttotal) {
        this.hirelisttotal = hirelisttotal;
    }

    /**
     * @return hirephyear
     */
    public Boolean getHirephyear() {
        return hirephyear;
    }

    /**
     * @param hirephyear
     */
    public void setHirephyear(Boolean hirephyear) {
        this.hirephyear = hirephyear;
    }

    /**
     * @return hirelistft
     */
    public Boolean getHirelistft() {
        return hirelistft;
    }

    /**
     * @param hirelistft
     */
    public void setHirelistft(Boolean hirelistft) {
        this.hirelistft = hirelistft;
    }

    /**
     * @return znj
     */
    public Boolean getZnj() {
        return znj;
    }

    /**
     * @param znj
     */
    public void setZnj(Boolean znj) {
        this.znj = znj;
    }

    /**
     * @return repairyearreport
     */
    public Boolean getRepairyearreport() {
        return repairyearreport;
    }

    /**
     * @param repairyearreport
     */
    public void setRepairyearreport(Boolean repairyearreport) {
        this.repairyearreport = repairyearreport;
    }

    /**
     * @return repairList
     */
    public Boolean getRepairlist() {
        return repairlist;
    }

    /**
     * @param repairlist
     */
    public void setRepairlist(Boolean repairlist) {
        this.repairlist = repairlist;
    }

    /**
     * @return propertychecktotal
     */
    public Boolean getPropertychecktotal() {
        return propertychecktotal;
    }

    /**
     * @param propertychecktotal
     */
    public void setPropertychecktotal(Boolean propertychecktotal) {
        this.propertychecktotal = propertychecktotal;
    }

    /**
     * @return safetychecktotal
     */
    public Boolean getSafetychecktotal() {
        return safetychecktotal;
    }

    /**
     * @param safetychecktotal
     */
    public void setSafetychecktotal(Boolean safetychecktotal) {
        this.safetychecktotal = safetychecktotal;
    }

    /**
     * @return hiddenquery
     */
    public Boolean getHiddenquery() {
        return hiddenquery;
    }

    /**
     * @param hiddenquery
     */
    public void setHiddenquery(Boolean hiddenquery) {
        this.hiddenquery = hiddenquery;
    }

    /**
     * @return propertylay
     */
    public Boolean getPropertylay() {
        return propertylay;
    }

    /**
     * @param propertylay
     */
    public void setPropertylay(Boolean propertylay) {
        this.propertylay = propertylay;
    }

    /**
     * @return road
     */
    public Boolean getRoad() {
        return road;
    }

    /**
     * @param road
     */
    public void setRoad(Boolean road) {
        this.road = road;
    }

    /**
     * @return depreciation
     */
    public Boolean getDepreciation() {
        return depreciation;
    }

    /**
     * @param depreciation
     */
    public void setDepreciation(Boolean depreciation) {
        this.depreciation = depreciation;
    }

    /**
     * @return messagecase
     */
    public Boolean getMessagecase() {
        return messagecase;
    }

    /**
     * @param messagecase
     */
    public void setMessagecase(Boolean messagecase) {
        this.messagecase = messagecase;
    }

    /**
     * @return propertytotal
     */
    public Boolean getPropertytotal() {
        return propertytotal;
    }

    /**
     * @param propertytotal
     */
    public void setPropertytotal(Boolean propertytotal) {
        this.propertytotal = propertytotal;
    }

    /**
     * @return hidden
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * @param hidden
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return HireManage
     */
    public Boolean getHiremanage() {
        return hiremanage;
    }

    /**
     * @param hiremanage
     */
    public void setHiremanage(Boolean hiremanage) {
        this.hiremanage = hiremanage;
    }

    /**
     * @return LoginView
     */
    public Boolean getLoginview() {
        return loginview;
    }

    /**
     * @param loginview
     */
    public void setLoginview(Boolean loginview) {
        this.loginview = loginview;
    }
}