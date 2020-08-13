package com.voucher.manage2.controller;

import com.voucher.manage2.service.SecurityConditionService;
import com.voucher.manage2.service.UserService;
import com.voucher.manage2.tkmapper.entity.User;
import com.voucher.manage2.utils.PropertiesUtils;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "version",produces = {"text/json;charset=utf-8"})
public class VersionController {

    @Resource
    private UserService userService;
    @Resource
    private SecurityConditionService service;

    //版本控制
    @RequestMapping("configuration")
    @Test
    public void emptyRoom(){
        String s = PropertiesUtils.returnValue("version");
        System.out.println(s);
    }


    @RequestMapping("login")
    public String login(@RequestBody User user, HttpSession session){
        String username = user.getUsername();
        String pwd = user.getPwd();
        Map<String, String> map = userService.login(username,pwd,session);

        /*//将账号，密码存在session中
        session.getServletContext().setAttribute("user_session",user);

        String token=TokenUtils.token(username,pwd);
        session.getServletContext().setAttribute("token",token);

        //设置过期时间
        session.setMaxInactiveInterval(6000);*/

        return JSONObject.fromObject(map).toString();
    }

}
