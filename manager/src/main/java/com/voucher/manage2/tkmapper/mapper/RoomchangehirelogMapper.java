package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Roomchangehirelog;
import com.voucher.manage2.tkmapper.entity.Roomexitlog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomchangehirelogMapper extends Mapper<Roomchangehirelog>, InsertListMapper<Roomchangehirelog> {
    @Select("select optDate,OHire,NHire from RoomChangeHireLog  order by optDate asc")
    List<Roomchangehirelog> findHireType();
}