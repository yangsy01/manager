package com.voucher.manage2.controller;

import com.voucher.manage2.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description
 * @date 2019/6/11
 */
@RestController
@CrossOrigin
@RequestMapping("/login")
public class UserController {

    @RequestMapping("logout")
    public void logout(HttpSession session) {
        //清除session
        session.invalidate();
    }

    @Resource
    private UserService userService;
    @RequestMapping("login")
    public String login(@RequestBody String username, @RequestBody String password, HttpSession session){
        Map<String, String> map = userService.login(username,password,session);

        return JSONObject.fromObject(map).toString();
    }



}
