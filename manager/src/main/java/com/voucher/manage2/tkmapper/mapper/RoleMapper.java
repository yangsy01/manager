package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.Role;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role>, InsertListMapper<Role> {
    @Select("select * from Role where GUID = #{roleguid} ")
    Role findByGuid(String roleguid);
}