package com.zxf.hello.spring.cloud.eth.read.consumer.feign.service;

import com.zxf.hello.spring.cloud.eth.read.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.eth.read.consumer.feign.service.fallback.ConnectServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxf
 * @date 2019/2/26 12:32
 */
@Service
@FeignClient(value = "ethereum-provider", fallback = ConnectServiceFallback.class)
public interface ConnectService {

    /**
     * 获取账户的以太币值
     * */
    @RequestMapping(value = "/connect/getbalance")
    public BaseResult getConnect();

    /**
     * 获得主账号
     * */
    @RequestMapping(value = "/connect/getethbase")
    public BaseResult getEthCoinbase();

    @RequestMapping(value = "/connect/getblocknumber")
    public BaseResult getBlockNumber();

    @RequestMapping(value = "/connect/getnetlistening")
    public BaseResult getNetListening();

    @RequestMapping(value = "/connect/getpeercount")
    public BaseResult getPeerCount();

    @RequestMapping(value = "/connect/getethming")
    public BaseResult getEthMining();

    @RequestMapping(value = "/connect/getethhashrate")
    public BaseResult getEthHashrate();

    @RequestMapping(value = "/connect/getethgasprice")
    public BaseResult getEthGasPrice();

    @RequestMapping(value = "/connect/getethaccounts")
    public BaseResult getEthAccounts();


}
