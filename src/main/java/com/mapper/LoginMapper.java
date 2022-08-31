package com.mapper;

import com.result.R;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    public Integer registered(@Param("userName") String userName,
                              @Param("userAccount") String userAccount,
                              @Param("passWord") String passWord);

}
