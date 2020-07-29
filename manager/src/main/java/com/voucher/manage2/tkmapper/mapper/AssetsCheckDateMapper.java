package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.AssetsCheckDate;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AssetsCheckDateMapper extends Mapper<AssetsCheckDate>, InsertListMapper<AssetsCheckDate> {

    @Select("select * from Assets_Check_Date where check_id = #{checkId}")
    List<AssetsCheckDate> findByCheckId(String checkId);
}