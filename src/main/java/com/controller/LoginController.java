package com.controller;

import com.result.R;
import com.service.LoginService;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* @author hanfx
* @date 2022年8月28日
* @explain 系统登录/注册
* */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    //注册
    @PostMapping("registered")
    public R registered(@RequestParam("userName") String userName,
                        @RequestParam("userAccount") String userAccount,
                        @RequestParam("passWord") String passWord,
                        @RequestParam("againUserPwd") String againUserPwd){
        if (passWord.equals(againUserPwd)){
            R registered = loginService.registered(userName, userAccount, passWord);
            return registered;
        }else {
            //如果两次密码不一致
            return R.error().message("密码不一致");
        }
    }
}
