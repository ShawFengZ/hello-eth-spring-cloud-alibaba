package com.zxf.hello.spring.cloud.ethereum.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zxf
 * @date 2019/2/25 14:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EthereumProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EthereumProviderApplication.class, args);
    }
}
