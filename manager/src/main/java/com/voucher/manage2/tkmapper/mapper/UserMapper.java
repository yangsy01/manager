package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User>, InsertListMapper<User> {

    @Select("select * from [User] where UserName = #{username}")
    User findByUserName(String username);

    @Select("SELECT url FROM(SELECT model_guid FROM (SELECT role_guid FROM sys_user_role WHERE user_guid = '${userGuid}') role " +
            "LEFT JOIN sys_role_model srm ON role.role_guid = srm.role_guid) " +
            "model LEFT JOIN sys_model_url smu ON model.model_guid=smu.model_guid")
    List<String> userAllPermission(@Param("userGuid") String userGuid);
}
