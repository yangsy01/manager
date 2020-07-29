package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.RoomLog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomLogMapper extends Mapper<RoomLog>, InsertListMapper<RoomLog> {
    @Select("select * from RoomLog where RoomGUID = ${guid}")
    RoomLog findRoomGuid(String guid);

    @Select("select * from RoomLog where RoomGUID = #{roomGuid} ORDER BY ActionDate asc  ")
    List<RoomLog> findByRoomGuid(String roomGuid);

    @Select("select * from RoomLog where RoomGUID = #{roomGuid} and   ActionType = '维修' ORDER BY ActionDate asc ")
    List<RoomLog> findRepairByRoomGuid(String roomGuid);
}