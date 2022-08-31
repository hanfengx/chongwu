package com.service.serviceImp;

import com.mapper.LoginMapper;
import com.result.R;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public R registered(String userName, String userAccount, String passWord) {
        Integer registered = loginMapper.registered(userName, userAccount, passWord);
        if (registered.equals(1)){
            return R.ok().message("注册成功");
        }else {
            return R.error().message("注册失败");
        }
    }
}
