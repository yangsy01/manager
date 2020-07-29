package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.ChartInfoDTO;
import com.voucher.manage2.dto.EntityDTO;
import com.voucher.manage2.dto.KeyDateDTO;
import com.voucher.manage2.dto.roomInfo.ChartInfoDto;
import com.voucher.manage2.tkmapper.entity.ChartInfoPro;
import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roominfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ChartinfoMapper extends Mapper<Chartinfo>, InsertListMapper<Chartinfo> {


    @Select("select GUID,TotalHire from ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') and IsHistory = '0'")
    List<Chartinfo> totalHire();

    @Select("select ConcludeDate,TotalHire from ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') and IsHistory = '0' ORDER BY ConcludeDate asc")
    List<Chartinfo> findTotalHireBar();


    @Select(" select COUNT(1) from RoomInfo where State='已出租' and ValidState=0 GROUP BY ChartGUID ")
    List<Integer> findCount();


    @Select("select RoomProperty,ConcludeDate from ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') and IsHistory = '0'  order by ConcludeDate asc")
    public List<Chartinfo> findRoomProperty();

    @Select("SELECT ConcludeDate FROM ChartInfo WHERE GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') and IsHistory = '0'  order by ConcludeDate asc")
    List<Chartinfo> findCountBar();


    @Select("select ConcludeDate from ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') and IsHistory = '0' order by ConcludeDate asc")
    List<Chartinfo> findIsHistory();


    //=========== 详情 =================

    @Select("SELECT GUID chartGuid,ContractNo,Charter,RoomAddress,Area,Hire,ChartCriterion,ConcludeDate,ChartBeginDate,ChartEndDate,Memo FROM ChartInfo   WHERE IsHistory = '0'and GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0') ")
    List<ChartInfoDTO> findDetails();

    @Select("SELECT GUID chartGuid,ContractNo chartGuid,Charter,RoomAddress,Area,Hire,ChartCriterion,ConcludeDate,ChartBeginDate,ChartEndDate,Memo FROM ChartInfo where ChartEndDate < #{date}  and IsHistory = '0' ")
    List<ChartInfoDTO> findOverdueRoomDetails(Date date);


    @Select("select * from ChartInfo  where GUID = #{chartGuid} ")
    Chartinfo findByGuid(String chartGuid);

    @Select("select * from ChartInfo  where GUID = #{chartGuid} ")
    Chartinfo findByChartGuid(String chartGuid);

    @Select("SELECT  COUNT(1) FROM ChartInfo WHERE ChartEndDate < #{date}  and IsHistory = '0' ")
    Integer findExpire(Date date);

    @Select("SELECT ConcludeDate FROM ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0' ) and IsHistory = '0' and len(ConcludeDate)>0  ORDER BY ConcludeDate")
    List<Date> findConcludeDate();

    //柱状图数据修改
    @Select("SELECT count(1) FROM ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0' ) and IsHistory = '0' AND ConcludeDate < #{date} ")
    Integer findCountByNow(Date date);

    @Select("SELECT sum(totalHire) FROM ChartInfo where GUID IN (SELECT ChartGUID FROM RoomInfo WHERE ValidState = '0' ) and IsHistory = '0' AND ConcludeDate < #{date} ")
    Double findTotalHireByNow(Date date);
}