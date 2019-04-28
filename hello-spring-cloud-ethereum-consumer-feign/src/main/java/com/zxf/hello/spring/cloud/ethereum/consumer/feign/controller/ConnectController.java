package com.zxf.hello.spring.cloud.ethereum.consumer.feign.controller;

import com.zxf.hello.spring.cloud.ethereum.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.ethereum.consumer.feign.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/27 9:40
 */
@RestController
@RequestMapping(value = "/connectconsumer")
public class ConnectController {

    @Autowired
    private ConnectService connectService;

    /**
     * 获取账户的以太币值
     * */
    @RequestMapping(value = "/getbalance")
    public BaseResult getConnect(){
        BaseResult connect = connectService.getConnect();
        return connect;
    }

    /**
     * 获得主账号
     * */
    @RequestMapping(value = "/getethbase")
    public BaseResult getEthCoinbase() {
        BaseResult ethCoinbase = connectService.getEthCoinbase();
        return ethCoinbase;
    }

    /**
     * 获取区块号
     * */
    @RequestMapping(value = "/getblocknumber")
    public BaseResult getBlockNumber() {
        BaseResult blockNumber = connectService.getBlockNumber();
        return blockNumber;
    }

    /**
     * 获取网络的监听状态
     * */
    @RequestMapping(value = "/getnetlistening")
    public BaseResult getNetListening() {
        BaseResult netListening = connectService.getNetListening();
        return netListening;
    }

    /**
     * 获取网络中的其他节点数
     * */
    @RequestMapping(value = "/getpeercount")
    public BaseResult getPeerCount() {
        BaseResult peerCount = connectService.getPeerCount();
        return peerCount;
    }

    /**
     * 获取当前是否在挖矿
     * */
    @RequestMapping(value = "/getethming")
    public BaseResult getEthMining() {
        BaseResult ethMining = connectService.getEthMining();
        return  ethMining;
    }

    /**
     * 获取当前哈希率
     * */
    @RequestMapping(value = "/getethhashrate")
    public BaseResult getEthHashrate() {
        BaseResult ethHashrate = connectService.getEthHashrate();
        return ethHashrate;
    }

    /**
     * 获取当前gas价格
     * */
    @RequestMapping(value = "/getethgasprice")
    public BaseResult getEthGasPrice() {
        BaseResult ethGasPrice = connectService.getEthGasPrice();
        return ethGasPrice;
    }

    /**
     * 获取当前账户
     * */
    @RequestMapping(value = "/getethaccounts")
    public BaseResult getEthAccounts() {
        BaseResult ethAccounts = connectService.getEthAccounts();
        return ethAccounts;
    }


}
