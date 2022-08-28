package com.mapper;

import com.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {

    public List<Test> test(@Param("userId") String userId);

}
