package com.entity;

import lombok.Data;

/*
* @author hanfx
* @date 2022年8月31日
* @explain 验证码实体类
* */
@Data
public class VerifyCode {
    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
