package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Chartinfo;
import com.voucher.manage2.tkmapper.entity.Roomrepairlog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomrepairlogMapper extends Mapper<Roomrepairlog>, InsertListMapper<Roomrepairlog> {

    @Select("select Type,RepairDate from RoomRepairLog  order by RepairDate asc")
    public List<Roomrepairlog> findType();

    @Select("select * from RoomRepairLog where RoomAddress LIKE #{address} ")
    List<Roomrepairlog> findByGuid(String address);
}