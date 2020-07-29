package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.HiddenNeaten;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HiddenNeatenMapper extends Mapper<HiddenNeaten>, InsertListMapper<HiddenNeaten> {
    @Select("select date,Area,AmountTotal,Amount,AuditingAmount from Hidden_Neaten order by date asc")
    List<HiddenNeaten> findData();

    @Select("select * from Hidden_Neaten where GUID = #{roomGuid} ")
    HiddenNeaten findByRoomGuid(String roomGuid);

    @Select("select date,Area,AmountTotal,Amount,AuditingAmount from Hidden_Neaten where date BETWEEN #{date1} AND #{date2} order by date asc")
    List<HiddenNeaten> findDataByDate(@Param("date1") String date1, @Param("date2")String date2);
}