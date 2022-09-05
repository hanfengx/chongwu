package com.entity;

import lombok.Data;
/*
* @author hangx
* @date 2022年8月31日
* @explain 用户实体类
* */
@Data
public class User {

    private String userName;

    private String userPwd;

    private String userState;

    private String userAccount;

    private String userPermission;

}
