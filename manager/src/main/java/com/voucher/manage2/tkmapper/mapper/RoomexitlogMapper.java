package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Roomexitlog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomexitlogMapper extends Mapper<Roomexitlog>, InsertListMapper<Roomexitlog> {
    @Select("select ConcludeDate,ExitType,Area from RoomExitLog  order by ConcludeDate asc")
    public List<Roomexitlog> findType();

    @Select("select count(*) from RoomExitLog")
    int findCount();

    @Select("select count(Area) from RoomExitLog")
    double findAreaCount();

    @Select("select Area,ConcludeDate from RoomExitLog order by ConcludeDate asc")
    List<Roomexitlog> findAreaBar();
}