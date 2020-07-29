package com.voucher.manage2.tkmapper.mapper;

import com.voucher.manage2.tkmapper.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>, InsertListMapper<User> {

    @Select("select * from [User] where UserName = #{username}")
    User findByUserName(String username);
}