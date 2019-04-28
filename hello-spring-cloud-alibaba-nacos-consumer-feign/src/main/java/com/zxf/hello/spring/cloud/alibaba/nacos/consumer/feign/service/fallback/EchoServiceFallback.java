package com.zxf.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;

import com.zxf.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * @author zxf
 * @date 2019/2/26 11:10
 */
@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String message) {
        return "echo fallback";
    }
}
