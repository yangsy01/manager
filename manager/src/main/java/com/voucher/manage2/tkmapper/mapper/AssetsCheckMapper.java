package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.AssetsCheck;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AssetsCheckMapper extends Mapper<AssetsCheck>, InsertListMapper<AssetsCheck> {

    @Select("select * from Assets_Check where GUID = #{roomGuid}  ")
    List<AssetsCheck> findByRoomGuid(String roomGuid);
}