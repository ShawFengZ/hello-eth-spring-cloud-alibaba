package com.zxf.hello.spring.cloud.ethereum.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zxf
 * @date 2019/2/26 10:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EthereumConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(EthereumConsumerFeignApplication.class, args);
    }
}
