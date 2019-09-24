package com.soar.vote;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 */
@SpringBootApplication
@MapperScan(basePackages = "com.soar.vote.persistence.mapper")
@Slf4j
public class VoteFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoteFrontApplication.class, args);
        log.info("投票系统-前端服务 启动完成！！！\n" +
                "========================================================================================================================================================");
    }

}
