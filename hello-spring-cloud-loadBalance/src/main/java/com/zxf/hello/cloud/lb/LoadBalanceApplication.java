package com.zxf.hello.cloud.lb;

import com.zxf.hello.cloud.lb.service.LoadBalanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoadBalanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }
}
