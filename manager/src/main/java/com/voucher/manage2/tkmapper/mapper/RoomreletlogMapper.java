package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Roominfo;
import com.voucher.manage2.tkmapper.entity.Roomreletlog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomreletlogMapper extends Mapper<Roomreletlog>, InsertListMapper<Roomreletlog> {

    @Select("select RoomProperty from RoomReletLog")
    public List<Roomreletlog> findRoomProperty();
}