package com.voucher.manage2.service.impl;

import com.voucher.manage2.service.UserService;
import com.voucher.manage2.tkmapper.entity.Role;
import com.voucher.manage2.tkmapper.entity.User;
import com.voucher.manage2.tkmapper.mapper.RoleMapper;
import com.voucher.manage2.tkmapper.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;


    @Override
    public Map<String, String> login(String username, String password) {
        User user = userMapper.findByUserName(username);
        Map<String, String> map = new HashMap<>();
        if(user == null){
            map.put("codemessage","不存在该账户");
            return map;
        }else {
            String pwd = user.getPwd();
            if(!password.equals(pwd)){
                map.put("codemessage","密码错误");
                return map;
            }else {
                map.put("codemessage","登录成功");
                return map;
            }
        }
    }
}
