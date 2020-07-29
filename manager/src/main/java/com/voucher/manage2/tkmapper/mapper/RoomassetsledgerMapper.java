package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.tkmapper.entity.Roomassetsledger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomassetsledgerMapper extends Mapper<Roomassetsledger>, InsertListMapper<Roomassetsledger> {

    @Select("SELECT AssetsLedgerType,area FROM   RoomAssetsLedger ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address where ra.AssetsLedgerDate   like '%' + #{nowYear} + '%' ")
    List<Roomassetsledger> findLedgerType(String nowYear);

    @Select("select Area,AssetsLedgerDate,AssetsLedgerType from RoomAssetsLedger order by AssetsLedgerDate asc")
    List<Roomassetsledger> findDateAndType();

    @Select("SELECT COUNT(1) FROM   RoomAssetsLedger ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address WHERE AssetsLedgerDate   like '%' + #{nowYear} + '%' and LEN(r.GUID) > 0  AND LEN(ra.AssetsLedgerType) > 0  ")
    Integer findCount(String nowYear);

    @Select("SELECT sum(area) FROM   RoomAssetsLedger ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address WHERE AssetsLedgerDate   like '%' + #{nowYear} + '%' and LEN(r.GUID) > 0 AND LEN(ra.AssetsLedgerType) > 0 ")
    Double findAreaCount(String nowYear);

    @Select("select Area,AssetsLedgerDate from RoomAssetsLedger order by AssetsLedgerDate asc")
    List<Roomassetsledger> findAreaBar();

    @Select("SELECT ra.*,c.Charter,c.TotalHire FROM (SELECT r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,r.ChartGUID FROM     (SELECT * FROM RoomAssetsLedger WHERE AssetsLedgerDate  like '%' + #{nowYear} + '%' AND LEN(AssetsLedgerType) > 0 )  ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address) ra LEFT JOIN ChartInfo c ON ra.ChartGUID = c.GUID  WHERE LEN(ra.roomGuid) > 0 ")
    List<RoomInfoDTO> rentCutDetails(String nowYear);

//    @Select("SELECT AssetsLedgerType name,COUNT(AssetsLedgerType) countD,SUM(Area) sumD FROM RoomAssetsLedger  GROUP BY AssetsLedgerType")
@Select("SELECT AssetsLedgerType name,COUNT(AssetsLedgerType) countD,SUM(Area) sumD FROM (SELECT ra.Area,ra.AssetsLedgerType FROM RoomAssetsLedger ra LEFT JOIN RoomInfo r ON ra.RoomAddress LIKE r.Address WHERE LEN(r.GUID) > 0) raa GROUP BY AssetsLedgerType")
List<CountAndSum> findByType();

//    @Select("SELECT AssetsLedgerType name,COUNT(AssetsLedgerType) countD,SUM(Area) sumD FROM RoomAssetsLedger where AssetsLedgerDate BETWEEN #{date1} AND #{date2}  GROUP BY AssetsLedgerType")
    @Select("SELECT AssetsLedgerType name,COUNT(AssetsLedgerType) countD,SUM(Area) sumD FROM (SELECT ra.Area,ra.AssetsLedgerType,ra.AssetsLedgerDate FROM RoomAssetsLedger ra LEFT JOIN RoomInfo r ON ra.RoomAddress LIKE r.Address WHERE LEN(r.GUID) > 0) raa where AssetsLedgerDate BETWEEN #{date1} AND #{date2} GROUP BY AssetsLedgerType")
    List<CountAndSum> findByDateType(@Param("date1") String date1, @Param("date2")String date2);
}