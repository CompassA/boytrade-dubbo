package org.study;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@SpringBootApplication
@EnableDubbo
public class BoyTradeControllerStarter {

    public static void main(String[] args) {
        SpringApplication.run(BoyTradeControllerStarter.class, args);
    }

}
