package com.voucher.manage2.service;

import com.voucher.manage2.dto.SysUserDTO;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {
    Map<String, String> login(String username, String password, HttpSession session);

    boolean hasPermission(SysUserDTO sysUser, String url);


}
