package com.zxf.hello.spring.cloud.eth.read.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EthereumReadConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(EthereumReadConsumerFeignApplication.class, args);
    }
}
