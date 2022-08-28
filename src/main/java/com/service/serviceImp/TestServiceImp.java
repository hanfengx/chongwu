package com.service.serviceImp;

import com.entity.Test;
import com.mapper.TestMapper;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImp implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> test(String userId) {
        System.out.println(userId);
        return testMapper.test(userId);
    }
}
