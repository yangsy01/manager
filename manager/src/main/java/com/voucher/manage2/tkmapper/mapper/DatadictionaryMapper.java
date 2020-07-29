package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Datadictionary;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DatadictionaryMapper extends Mapper<Datadictionary>, InsertListMapper<Datadictionary> {
    @Select("select Content from DataDictionary")
    List<Datadictionary> findContent();
}