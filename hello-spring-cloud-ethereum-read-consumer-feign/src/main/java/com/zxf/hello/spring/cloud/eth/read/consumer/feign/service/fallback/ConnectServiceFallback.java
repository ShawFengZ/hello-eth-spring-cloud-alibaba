package com.zxf.hello.spring.cloud.eth.read.consumer.feign.service.fallback;

import com.zxf.hello.spring.cloud.eth.read.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.eth.read.consumer.feign.service.ConnectService;
import org.springframework.stereotype.Component;

/**
 * @author zxf
 * @date 2019/2/26 12:33
 */
@Component
public class ConnectServiceFallback implements ConnectService {

    BaseResult baseResult = new BaseResult();
    /**
     * 获取账户的以太币值
     */
    @Override
    public BaseResult getConnect() {
        baseResult.setStatus(500);
        baseResult.setMessage("connect fallback");
        return baseResult;
    }

    /**
     * 获得主账号
     */
    @Override
    public BaseResult getEthCoinbase() {
        baseResult.setStatus(500);
        baseResult.setMessage("getCoinbase fallback");
        return baseResult;
    }

    @Override
    public BaseResult getBlockNumber() {
        baseResult.setStatus(500);
        baseResult.setMessage("getBlockNumber fallback");
        return baseResult;
    }

    @Override
    public BaseResult getNetListening() {
        baseResult.setStatus(500);
        baseResult.setMessage("getNetListening fallback");
        return baseResult;
    }

    @Override
    public BaseResult getPeerCount() {
        baseResult.setStatus(500);
        baseResult.setMessage("getPeerCount fallback");
        return baseResult;
    }

    @Override
    public BaseResult getEthMining() {
        baseResult.setStatus(500);
        baseResult.setMessage("getEthMining fallback");
        return baseResult;
    }

    @Override
    public BaseResult getEthHashrate() {
        baseResult.setStatus(500);
        baseResult.setMessage("getEthHashrate fallback");
        return baseResult;
    }

    @Override
    public BaseResult getEthGasPrice() {
        baseResult.setStatus(500);
        baseResult.setMessage("getEthGasPrice fallback");
        return baseResult;
    }

    @Override
    public BaseResult getEthAccounts() {
        baseResult.setStatus(500);
        baseResult.setMessage("getEthAccounts fallback");
        return baseResult;
    }
}
