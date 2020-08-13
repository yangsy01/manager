package com.voucher.manage2.service.impl;

import com.voucher.manage2.dto.SysUserDTO;
import com.voucher.manage2.service.UserService;
import com.voucher.manage2.tkmapper.entity.SysUser;
import com.voucher.manage2.tkmapper.entity.User;
import com.voucher.manage2.tkmapper.mapper.RoleMapper;
import com.voucher.manage2.tkmapper.mapper.UserMapper;
import com.voucher.manage2.utils.CommonUtils;
import com.voucher.manage2.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Autowired
    private UserServiceImpl userService;


    @Override
    public Map<String, String> login(String username, String password, HttpSession session) {
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
                //创建token
                String token= TokenUtils.token(username,pwd);

                //登陆成功将token传给前端
                map.put("codemessage","登录成功");
                map.put("token",token);

                return map;
            }
        }
    }

    @Override
    public boolean hasPermission(SysUserDTO sysUser, String url) {
        if (CommonUtils.isSuperAdmin()) {
            return true;
        }
        return userService.userAllPermission(sysUser).contains(url);
    }

    public List<String> userAllPermission(SysUser sysUser) {
        return userMapper.userAllPermission(sysUser.getGuid());
    }
}
