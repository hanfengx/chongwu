package com.controller;

import com.entity.Test;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testone")
    public List<Test> test(@RequestParam("userId") String userId){

        return testService.test(userId);
    }

}
