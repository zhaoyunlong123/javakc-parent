package com.javakc.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @program: javakc-parent
 * @Description: 主程序
 * @Author: zhao yun long
 * @date: 2020/11/23 22:36
 */
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"com.javakc"})
@EnableDiscoveryClient
@EnableFeignClients
public class PmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }

}
