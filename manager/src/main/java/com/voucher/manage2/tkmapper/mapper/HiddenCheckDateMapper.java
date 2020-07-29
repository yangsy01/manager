package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.HiddenCheckDate;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HiddenCheckDateMapper extends Mapper<HiddenCheckDate>, InsertListMapper<HiddenCheckDate> {

    @Select("select * from Hidden_Check_Date where check_id = #{checkId} ")
    List<HiddenCheckDate> findByCheckId(String checkId);
}