package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.RoominfoHiddenItem;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface RoominfoHiddenItemMapper extends Mapper<RoominfoHiddenItem>, InsertListMapper<RoominfoHiddenItem> {
    @Select("SELECT COUNT(1) FROM RoomInfo_Hidden_Item WHERE line_aging > 0 OR wire_chaos > 0 OR valve_aging > 0  OR high_power > 0 or fire_extinguisher > 0 OR fire_aging > 0 or blow > 0 or other_fire_hazards > 0 ")
    Integer findHuoZai();

    @Select("SELECT COUNT(1) FROM RoomInfo_Hidden_Item WHERE incline > 0 or split > 0 or collapse > 0 or flaw > 0 or invalidation > 0 or break_off > 0 or destroy >0 ")
    Integer findRoomStru();

    @Select("SELECT COUNT(1) FROM RoomInfo_Hidden_Item WHERE wall_up > 0 or cesspool > 0 or warning_missing  > 0 or  secure_channel > 0 or handrail_destroy > 0 or other_supporting > 0 ")
    Integer findSheShi();

    @Select("SELECT COUNT(1) FROM RoomInfo_Hidden_Item WHERE flooding > 0 or coast > 0 or earthquake > 0 or down > 0 or snow > 0")
    Integer findNatural();
}