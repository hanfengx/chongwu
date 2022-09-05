package com.service;

import com.result.R;

public interface LoginService {

    public R registered(String userName,String userAccount,String passWord);

    public R login(String userName,String passWord);

}
