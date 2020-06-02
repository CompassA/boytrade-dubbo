package org.study;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = {"org.study.mapper"})
public class BoyTradeServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(BoyTradeServiceStarter.class, args);
    }

}
