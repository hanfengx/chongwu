package com.controller;

import com.entity.VerifyCode;
import com.result.R;
import com.service.IVerifyCodeGenService;
import com.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Autowired
    private IVerifyCodeGenService iVerifyCodeGen;


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

    @ApiOperation(value = "验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
        }
    }

    //登录
    @PostMapping("submit")
    public R login(@RequestParam("userName") String userName,
                   @RequestParam("passWord") String passWord,
                   @RequestParam("verifyCode")String verifyCode,
                   HttpServletRequest request){
        String sessionVerifyCode = request.getSession().getAttribute("VerifyCode").toString();
        //先判断验证码是否正确
        if (verifyCode.toUpperCase().equals(sessionVerifyCode)){
            return loginService.login(userName, passWord);
        }else {
            return R.error().message("验证码错误，请重新输入");
        }
    }
}
