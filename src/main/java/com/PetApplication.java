package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.mapper")
public class PetApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PetApplication.class, args);
        Environment environment = run.getBean(Environment.class); //获取端口号
        System.out.println("==========启动成功==========端口号:"+environment.getProperty("server.port"));
    }
}
