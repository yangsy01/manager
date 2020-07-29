package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.CountAndSum;
import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.tkmapper.entity.Roomassetsaccounting;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomassetsaccountingMapper extends Mapper<Roomassetsaccounting>, InsertListMapper<Roomassetsaccounting> {

    @Select("SELECT AssetsAccountingType,Area FROM   RoomAssetsAccounting ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address  WHERE LEN(r.GUID) > 0 and ra.AssetsAccountingDate like '%' + #{nowYear} + '%' ")
    List<Roomassetsaccounting> findAccountingType(String nowYear);

    @Select("select Area,AssetsAccountingType,AssetsAccountingDate from RoomAssetsAccounting order by AssetsAccountingDate asc")
    List<Roomassetsaccounting> findDateAndType();

    @Select("SELECT count(1) FROM   RoomAssetsAccounting ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address  WHERE LEN(r.GUID) > 0  AND LEN(ra.AssetsAccountingType) > 0 and AssetsAccountingDate like '%' + #{nowYear} + '%' ")
    Integer findCount(String nowYear);

    @Select("SELECT sum(Area) FROM   RoomAssetsAccounting ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address  WHERE LEN(r.GUID) > 0 AND LEN(ra.AssetsAccountingType) > 0 and  AssetsAccountingDate like '%' + #{nowYear} + '%' ")
    Double findAreaCount(String nowYear);

    @Select("SELECT AssetsAccountingDate,Area FROM RoomAssetsAccounting order by AssetsAccountingDate asc")
    List<Roomassetsaccounting> findAreaBar();

    @Select("SELECT ra.*,c.Charter,c.TotalHire FROM (SELECT r.GUID roomGuid,r.Address,r.Num,r.RoomProperty,r.BuildArea,r.State,r.Structure,r.sMemo,r.ChartGUID FROM   (SELECT * FROM RoomAssetsAccounting WHERE AssetsAccountingDate like '%' + #{nowYear} + '%' ) ra LEFT JOIN RoomInfo r  ON  ra.RoomAddress  LIKE  r.Address) ra LEFT JOIN ChartInfo c ON ra.ChartGUID = c.GUID   WHERE LEN(ra.roomGuid) > 0 ")
    List<RoomInfoDTO> rentAddDetails(String nowYear);

//    @Select("SELECT AssetsAccountingType name,COUNT(AssetsAccountingType) countD,SUM(Area) sumD FROM RoomAssetsAccounting  GROUP BY AssetsAccountingType")
    @Select(" SELECT AssetsAccountingType name,COUNT(AssetsAccountingType) countD,SUM(Area) sumD FROM (SELECT ra.Area,ra.AssetsAccountingType FROM RoomAssetsAccounting ra LEFT JOIN RoomInfo r ON ra.RoomAddress LIKE r.Address WHERE LEN(r.GUID) > 0) raa  GROUP BY AssetsAccountingType ")
    List<CountAndSum> findByType();

//    @Select("SELECT AssetsAccountingType name,COUNT(AssetsAccountingType) countD,SUM(Area) sumD FROM RoomAssetsAccounting where AssetsAccountingDate BETWEEN #{date1} AND #{date2}  GROUP BY AssetsAccountingType")
    @Select("SELECT AssetsAccountingType name,COUNT(AssetsAccountingType) countD,SUM(Area) sumD FROM (SELECT ra.Area,ra.AssetsAccountingType,ra.AssetsAccountingDate FROM RoomAssetsAccounting ra LEFT JOIN RoomInfo r ON ra.RoomAddress LIKE r.Address WHERE LEN(r.GUID) > 0) raa where AssetsAccountingDate BETWEEN #{date1} AND #{date2}  GROUP BY AssetsAccountingType ")
    List<CountAndSum> findByDateType(@Param("date1") String date1, @Param("date2")String date2);
}