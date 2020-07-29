package com.voucher.manage2.controller;

import com.voucher.manage2.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public void logout() {

    }

    @Resource
    private UserService userService;
    @RequestMapping("login")
    public String login(@RequestBody String username,@RequestBody String password){
        Map<String, String> map = userService.login(username,password);
        return JSONObject.fromObject(map).toString();
    }



}
