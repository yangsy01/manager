package com.voucher.manage2.tkmapper.mapper;

import com.github.pagehelper.PageInfo;
import com.voucher.manage2.base.BasePage;
import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.KeyObjDTO;
import com.voucher.manage2.dto.KeyVCountDTO;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.dto.details.TopMessage;
import com.voucher.manage2.dto.roomInfo.AddressAndHireDTO;
import com.voucher.manage2.dto.roomInfo.DataList;
import com.voucher.manage2.dto.roomInfo.DataNumberDto;
import com.voucher.manage2.dto.roomInfo.RoomInfoDto;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.HiddenCheck;
import com.voucher.manage2.tkmapper.entity.Room;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RoominfoMapper extends Mapper<Roominfo>, InsertListMapper<Roominfo> {

    @Select("select BuildArea,RoomProperty,InDate from RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findArea();

    @Select("select BuildArea,RoomProperty,InDate from RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findRoomProperty();

    @Select("select State,RoomProperty,InDate,BuildArea from RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findState();

    @Select("select IsPawn,InDate,BuildArea from RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findIsPawn();

    @Select("select RoomProperty,IsPawn,BuildArea from RoomInfo WHERE ValidState = '0' ")
    List<Roominfo> findImPawn();

    @Select("select PropertyrightUnit,RealEstateNo,BuildArea,InDate,PropertyMemo from RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findCertificate();

    @Select("SELECT COUNT(1) FROM RoomInfo WHERE State = '空置' ")
    Integer findEmpty();

    @Select("SELECT Structure,InDate FROM RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findStructure();

    @Select("SELECT State,InDate FROM RoomInfo WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findEmptyRoom();

    @Select("select InDate from RoomInfo  WHERE ValidState = '0'  order by InDate asc")
    List<Roominfo> findCountBar();

    @Select("select BuildArea,InDate,RoomProperty from RoomInfo  WHERE ValidState = '0' order by InDate asc")
    List<Roominfo> findAreaBar();

//    ==========   详情 ===============

    @Select("SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roominfo  WHERE ValidState = '0' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ORDER BY r.InDate ")
    List<RoomInfoDTO> findDetails();

    @Select("SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roomInfo where State = '空置') r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> findEmptyDetails();


    @Select(" SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roomInfo where RoomProperty = '住宅房' and State = '已出租' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID  ")
    List<RoomInfoDTO> findRentRoomDetails();

    @Select(" SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roomInfo where RoomProperty = '营业房' and State = '已出租' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID  ")
    List<RoomInfoDTO> findBusinessRoomDetails();

    @Select("select count(*) from RoomInfo  WHERE ValidState = '0' ")
    int findCountRoomInfo();

    @Select("select BuildArea from RoomInfo  WHERE ValidState = '0' ")
    List<Roominfo> areaCount();

    @Select("SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roominfo  WHERE ValidState = '0' and len(GlebeCardNo) = 0 AND len(PropertyRightNo) = 0 and LEN(RealEstateNo) = 0 and LEN(RealEstateNo) = 0 ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> noCardDetails();

    @Select("SELECT  r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,c.charter,c.TotalHire FROM (select * from roominfo  WHERE ValidState = '0') r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID where IsPawn like '是' ")
    List<RoomInfoDTO> isPawn();


    @Select("select * from RoomInfo where GUID = #{roomGuid} ")
    Roominfo findByGuid(String roomGuid);

    @Select("select Count(isHidden) from RoomInfo where isHidden > 0  and ValidState = '0' and inDate LIKE '%' + #{date} + '%'    ")
    Integer hidDanger(String date );

    @Select("select Count(neaten_flow) from RoomInfo where neaten_flow > 0  and  ValidState = '0' and inDate LIKE '%' + #{date} + '%'  ")
    Integer abarbeitung(String date );

    @Select("select Count(1) from RoomInfo where neaten_flow = 0 and isHidden > 0  and ValidState = '0' and inDate LIKE '%' + #{date} + '%'  ")
    Integer noAbarbeitung(String date);

    @Select(" select Count(1) from (SELECT * FROM RoomInfo WHERE ValidState = '0'  ) r WHERE r.DangerClassification like 'D级'    ")
    Integer dgRoom();

    @Select("select isHidden from RoomInfo  where  ValidState = '0' ")
    List<Roominfo> findCheckName();

    @Select("select neaten_flow from RoomInfo where ValidState = '0' ")
    List<Roominfo> findNeatenFlow();

    @Select("select DangerClassification from RoomInfo where ValidState = '0' ")
    List<Roominfo> findDangerClassification();

    @Select("SELECT r.*,c.charter,c.TotalHire FROM (select GUID roomGuid,Address,Num,RoomProperty,BuildArea,State,Structure,sMemo,ChartGUID from RoomInfo where inDate LIKE '%' + #{date} + '%' and isHidden > 0 and ValidState = '0' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> hidDangerDetails(String date);

    @Select("SELECT r.*,c.charter,c.TotalHire FROM (select GUID roomGuid,Address,Num,RoomProperty,BuildArea,State,Structure,sMemo,ChartGUID from RoomInfo where inDate LIKE '%' + #{date} + '%' and neaten_flow > 0 and ValidState = '0'  ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> abarbeitungDetails(String date);

    @Select("SELECT r.*,c.charter,c.TotalHire FROM (select GUID roomGuid,Address,Num,RoomProperty,BuildArea,State,Structure,sMemo,ChartGUID from RoomInfo where inDate LIKE '%' + #{date} + '%' and neaten_flow = 0 and isHidden > 0  and ValidState = '0' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> noAbarbeitungDetails(String date);

    @Select("SELECT r.*,c.charter,c.TotalHire FROM (select GUID roomGuid,Address,Num,RoomProperty,BuildArea,State,Structure,sMemo,ChartGUID from RoomInfo where DangerClassification like 'D级'  and ValidState = '0' ) r LEFT JOIN ChartInfo c ON r.ChartGUID = c.GUID ")
    List<RoomInfoDTO> dangerRoomDetails();

    @Select(" SELECT r.* FROM (SELECT guid FROM Hidden_Check WHERE State = '整改完成'AND date LIKE '%' + #{date} + '%' ) hc LEFT JOIN (select GUID roomGuid,Address,Num,RoomProperty,BuildArea,State,Structure,sMemo,ChartGUID from RoomInfo  ) r ON hc.GUID = r.roomGuid ")
    List<RoomInfoDTO> findYiZGaiDetails(String date);

    @Select(" select InDate from RoomInfo  where ValidState = '0' AND LEN(InDate)>0 ORDER BY InDate asc ")
    List<Date> findDate();

    @Select("select InDate,isHidden from RoomInfo  where ValidState = '0' ORDER BY InDate asc ")
    List<Roominfo> findHidDanger();

    @Select("select InDate,neaten_flow from RoomInfo  where ValidState = '0' ORDER BY InDate asc ")
    List<Roominfo> findAbarbeitung();

    @Select("select InDate,neaten_flow,isHidden from RoomInfo  where ValidState = '0' ORDER BY InDate asc ")
    List<Roominfo> weiZhengGai();

    @Select("select InDate,DangerClassification from RoomInfo  where ValidState = '0' ORDER BY InDate asc ")
    List<Roominfo> findDgHouse();

    @Select("SELECT room.SecurityRegion,COUNT(room.SecurityRegion) count FROM (SELECT SecurityRegion FROM RoomInfo WHERE LEN(SecurityRegion) > 0 and ValidState = '0' ) room GROUP BY  room.SecurityRegion")
    List<Map<String,Object>> findSecurityRegion();

//    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(PropertyRightNo) card,SUM(BuildArea) area FROM RoomInfo WHERE PropertyRightNo <>'' and LEN(PropertyRightNo) > 0  AND LEN(GlebeCardNo)= 0 AND LEN(RealEstateNo)= 0 and ValidState = '0' GROUP BY PropertyRightNo) b")
    @Select("SELECT count(PropertyRightNo) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE PropertyRightNo <>'' and LEN(PropertyRightNo) > 0  AND LEN(GlebeCardNo)= 0 AND LEN(RealEstateNo)= 0 and ValidState = '0'")
    Map<String, Object> findPropertyRightNo();

//    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(GlebeCardNo) card,SUM(BuildArea) area FROM RoomInfo WHERE GlebeCardNo <>'' and LEN(PropertyRightNo) = 0  AND LEN(GlebeCardNo) > 0 AND LEN(RealEstateNo)= 0 and ValidState = '0' GROUP BY GlebeCardNo) b")
    @Select("SELECT count(GlebeCardNo) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE GlebeCardNo <>'' and LEN(PropertyRightNo) = 0  AND LEN(GlebeCardNo) > 0 AND LEN(RealEstateNo)= 0 and ValidState = '0'")
    Map<String, Object> findGlebeCardNo();

//    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(RealEstateNo) card,SUM(BuildArea) area FROM RoomInfo WHERE RealEstateNo <>'' and RealEstateNo is not null and ValidState = '0' GROUP BY RealEstateNo) b ")
    @Select("SELECT count(RealEstateNo) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE RealEstateNo <>'' and RealEstateNo is not null and ValidState = '0'")
    Map<String, Object> findRealEstateNo();

//    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(GlebeCardNo) card,SUM(BuildArea) area FROM RoomInfo WHERE GlebeCardNo <>'' and LEN(GlebeCardNo) > 0  and LEN(PropertyRightNo) > 0 and ValidState = '0' GROUP BY GlebeCardNo) b ")
    @Select("SELECT count(GlebeCardNo) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE GlebeCardNo <>'' and LEN(GlebeCardNo) > 0  and LEN(PropertyRightNo) > 0 and ValidState = '0'\n")
    Map<String, Object> findTwo();

    @Select("SELECT COUNT(1) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE len(GlebeCardNo) = 0 AND len(PropertyRightNo) = 0 and LEN(RealEstateNo) = 0 and ValidState = '0' ")
    Map<String, Object> findNot();


    //    ==
    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(PropertyRightNo) card,SUM(BuildArea) area FROM RoomInfo WHERE ValidState = '0' and PropertyRightNo <>'' and LEN(PropertyRightNo) > 0  AND LEN(GlebeCardNo)= 0 and inDate BETWEEN #{date1} AND #{date2} GROUP BY PropertyRightNo) b")
    Map<String, Object> findPropertyRightNoByDate(@Param("date1") Date date1,@Param("date2")Date date2);

    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(GlebeCardNo) card,SUM(BuildArea) area FROM RoomInfo WHERE ValidState = '0' and GlebeCardNo <>'' and LEN(PropertyRightNo) = 0 and inDate BETWEEN #{date1} AND #{date2}  AND LEN(GlebeCardNo) > 0 GROUP BY GlebeCardNo) b")
    Map<String, Object> findGlebeCardNoByDate(@Param("date1") Date date1,@Param("date2")Date date2);

    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(RealEstateNo) card,SUM(BuildArea) area FROM RoomInfo WHERE ValidState = '0' and  RealEstateNo <>'' and RealEstateNo is not null and inDate BETWEEN #{date1} AND #{date2} GROUP BY RealEstateNo) b ")
    Map<String, Object> findRealEstateNoByDate(@Param("date1") Date date1,@Param("date2")Date date2);

    @Select("SELECT count(card) allCount, SUM(area) allArea FROM (SELECT count(GlebeCardNo) card,SUM(BuildArea) area FROM RoomInfo WHERE ValidState = '0' and GlebeCardNo <>'' and LEN(GlebeCardNo) > 0  and LEN(PropertyRightNo) > 0  GROUP BY GlebeCardNo) b")
    Map<String, Object> findTwoByDate(@Param("date1") Date date1,@Param("date2")Date date2);

    @Select("SELECT COUNT(1) allCount,SUM(BuildArea) allArea FROM RoomInfo WHERE ValidState = '0' and len(GlebeCardNo) = 0 AND len(PropertyRightNo) = 0 and inDate BETWEEN #{date1} AND #{date2} ")
    Map<String, Object> findNotByDate(@Param("date1") Date date1,@Param("date2")Date date2);

    @Select("SELECT COUNT(1) FROM RoomInfo WHERE ValidState = '0' and len(GlebeCardNo) = 0 AND len(PropertyRightNo) = 0 and LEN(RealEstateNo) = 0 and LEN(RealEstateNo) = 0 ")
    Integer findWeiBan();

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo where ValidState = '0'  GROUP BY RoomProperty")
    List<CountAndSum> findRoomPCountAndSum();

    @Select("SELECT Structure name,COUNT(Structure) countD, SUM(BuildArea) FROM RoomInfo where ValidState = '0' GROUP BY Structure")
    List<CountAndSum> findStructureCount();

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and RoomProperty = '住宅房' GROUP BY State")
    List<CountAndSum> findRoomByState();

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  RoomProperty = '营业房' GROUP BY State")
    List<CountAndSum> findDoBusByState();

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  RoomProperty in ('土地' , '其他') GROUP BY State")
    List<CountAndSum> findLandByState();

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  State = '已出租' GROUP BY RoomProperty")
    List<CountAndSum> findYiRent();

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  IsPawn = '是' GROUP BY RoomProperty")
    List<CountAndSum> findByIsPawn();

    @Select("SELECT Address,OriginalAddress,Num,BuildArea,hire,chartGuid FROM (select Address,OriginalAddress,Num,BuildArea,ChartGUID from roomInfo where GUID = #{guid} ) r LEFT JOIN ChartInfo c on r.ChartGUID = c.GUID ")
    TopMessage findTopMessage(String guid);

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and inDate BETWEEN #{date1} AND #{date2} GROUP BY RoomProperty")
    List<CountAndSum> findByDateArea(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and inDate BETWEEN #{date1} AND #{date2} GROUP BY RoomProperty")
    List<CountAndSum> findByDateCount(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT Structure name,COUNT(Structure) countD FROM RoomInfo where ValidState = '0' and inDate BETWEEN #{date1} AND #{date2} GROUP BY Structure")
    List<CountAndSum> findByDateStr(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and RoomProperty = '住宅房' and inDate BETWEEN #{date1} AND #{date2} GROUP BY State")
    List<CountAndSum> findRoomByDate(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  RoomProperty = '营业房' and inDate BETWEEN #{date1} AND #{date2} GROUP BY State")
    List<CountAndSum> findDoBusByDate(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  RoomProperty =in ('土地' , '其他') and inDate BETWEEN #{date1} AND #{date2} GROUP BY State")
    List<CountAndSum> findLandByDate(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  State = '已出租' and inDate BETWEEN #{date1} AND #{date2} GROUP BY RoomProperty")
    List<CountAndSum> findByDateYiRent(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT RoomProperty name,COUNT(RoomProperty) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and  IsPawn = '是' and inDate BETWEEN #{date1} AND #{date2} GROUP BY RoomProperty")
    List<CountAndSum> findByDateIsPawn(@Param("date1") String date1,@Param("date2")String date2);

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0'  and IsHidden > 0")
    Integer findYinHuan();

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0'  and neaten_flow > 0")
    Integer findZaiZhengGai();

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0'  and IsHidden > 0 and neaten_flow = 0 ")
    Integer findWeiZhengGai();

    @Select("select count(1) from RoomInfo  where ValidState = '0' and  DangerClassification = 'D级' ")
    Integer findWeiFang();

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0' and inDate BETWEEN #{date1} AND #{date2}  and IsHidden > 0")
    Integer findByDateYinHuan(@Param("date1") String date1,@Param("date2")String date2);

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0' and inDate BETWEEN #{date1} AND #{date2}  and neaten_flow > 0")
    Integer findByDateZaiZhengGai(@Param("date1") String date1,@Param("date2")String date2);

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0' and inDate BETWEEN #{date1} AND #{date2}  and IsHidden > 0 and neaten_flow = 0 ")
    Integer findByDateWeiZhengGai(@Param("date1") String date1,@Param("date2")String date2);

    @Select("select count(1) from RoomInfo  where ValidState = '0' and inDate BETWEEN #{date1} AND #{date2} and  DangerClassification = 'D级' ")
    Integer findByDateWeiFang(@Param("date1") String date1,@Param("date2")String date2);

    //柱状图修改
    @Select("SELECT COUNT(1) FROM RoomInfo WHERE ValidState = '0' AND InDate < #{date} ")
    Integer findCountByNow(Date date);

    @Select("SELECT SUM(BuildArea) FROM RoomInfo WHERE ValidState = '0' AND InDate < #{date} ")
    Double findAreaByNow(Date date);

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0'  and IsHidden > 0 and InDate < #{date} ")
    Integer findYinHuanByNow(Date date);

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' and inDate BETWEEN #{date1} AND #{date2} GROUP BY State ")
    List<CountAndSum> findRoomNatureByDate(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT COUNT(1) FROM RoomInfo WHERE ValidState = '0' ")
    Integer findAllRoom();

    @Select("select COUNT(1) from RoomInfo  where ValidState = '0'  and IsHidden > 0 ")
    Integer findAllYinHuan();


    @Select("SELECT sum(BuildArea) FROM RoomInfo WHERE ValidState = '0' ")
    Double findAllRoomArea();

    @Select("SELECT COUNT(1) countD,SUM(BuildArea) sumD FROM RoomInfo where ValidState = '0' ")
    CountAndSum findRoomCountAndSum();

    @Select("SELECT COUNT(1) countD,SUM(BuildArea) sumD FROM RoomInfo where ValidState = '0'  and   inDate BETWEEN #{date1} AND #{date2} ")
    CountAndSum findRoomCASByDate(@Param("date1") String date1,@Param("date2")String date2);

    @Select("SELECT COUNT(1)  FROM RoomInfo where ValidState = '0' and IsHidden > 0 and  inDate < #{date} ")
    Integer findYinHuanBy(Date date);

    @Select("SELECT COUNT(1)  FROM RoomInfo where ValidState = '0' and neaten_flow > 0 and  inDate < #{date} ")
    Integer findZhengZaiZG(Date date);

    @Select("SELECT COUNT(1)  FROM RoomInfo where ValidState = '0'  and IsHidden > 0 and neaten_flow = 0  and  inDate < #{date} ")
    Integer findWeiZG(Date date);

    @Select("SELECT Address FROM RoomInfo WHERE ChartGUID = #{guid} ")
    List<String> findByChartGuid(String guid);

    @Select("SELECT State name,COUNT(State) countD,SUM(BuildArea) sumD FROM RoomInfo WHERE ValidState = '0' GROUP BY State")
    List<CountAndSum> findRoomNature();


    @Select("SELECT SUM(BuildArea)  FROM RoomInfo WHERE ValidState = '0' and len(GlebeCardNo) = 0 AND len(PropertyRightNo) = 0 and LEN(RealEstateNo) = 0 and LEN(RealEstateNo) = 0 ")
    Double findWeiBanArea();

    @Select(" SELECT count(*) from (select chartGUID from RoomInfo where State='已出租' and ValidState=0 GROUP BY ChartGUID) chartG LEFT JOIN ChartInfo CI on chartG.ChartGUID = CI.guid WHERE CI.IsHistory=0 ")
    Integer findCountChart();

    /**
     * 查询资产数量
     */
    @Select("select InDate, count(*) as number from RoomInfo where InDate is not null GROUP BY InDate")
    List<DataList> dataNumber();
}
