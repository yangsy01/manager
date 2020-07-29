package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.dto.RoomInfoDTO;
import com.voucher.manage2.tkmapper.entity.HiddenCheck;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface HiddenCheckMapper extends Mapper<HiddenCheck>, InsertListMapper<HiddenCheck> {

    @Select("select state,date from Hidden_Check where check_name = '异常' and  order by date asc")
    List<HiddenCheck> findTypeAndState();

    @Select("select count(*) from Hidden_Check")
    Integer findCount();

    @Select("select date from Hidden_Check order by date asc ")
    List<Date> findDate();


    @Select("select * from Hidden_Check where GUID = #{roomGuid} ")
    List<HiddenCheck> findByRoomGuid(String roomGuid);

    @Select("select * from Hidden_Check where GUID = #{roomGuid} and State IN ('整改中','未整改') ")
    List<HiddenCheck> findNowByRoomGuid(String roomGuid);

    @Select("select count(1) from Hidden_Check where  State = '整改完成' and date < #{date}  ")
    Integer findYiZhengGaiByNow(Date date);

    @Select("select count(*) from Hidden_Check where date BETWEEN #{date1} AND #{date2}")
    Integer findByDateCount(@Param("date1") String date1, @Param("date2")String date2);

    @Select("select count(1) from Hidden_Check where  State = '整改完成' and date like '%' + #{date} + '%' ")
    Integer findYiZhengGai(String date);

    @Select("select count(1) from Hidden_Check where date < #{date} ")
    Integer xunCha(Date date);
}