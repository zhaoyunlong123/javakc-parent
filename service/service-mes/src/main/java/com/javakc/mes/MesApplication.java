package com.javakc.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @program: javakc-parent
 * @Description: mes启动类
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 20:40:23
 */
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"com.javakc"})
@EnableDiscoveryClient
public class MesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MesApplication.class, args);
    }
}
