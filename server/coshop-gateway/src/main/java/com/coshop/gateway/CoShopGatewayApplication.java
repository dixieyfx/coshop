package com.coshop.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dixiey
 * @version 1.0
 * @description:
 * @date 2023/11/26 22:59
 */
@SpringBootApplication
@EnableFeignClients
public class CoShopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoShopGatewayApplication.class,args);
    }
}
