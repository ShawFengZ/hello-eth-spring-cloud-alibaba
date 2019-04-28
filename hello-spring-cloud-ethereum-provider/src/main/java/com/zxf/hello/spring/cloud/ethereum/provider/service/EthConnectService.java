package com.zxf.hello.spring.cloud.ethereum.provider.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zxf
 * @date 2019/2/25 15:20
 */
public interface EthConnectService {
    /**
     * 获取值
     * */
    public BigInteger getBalance(String address) throws IOException;

    /**
     * 获取当前主账号
     * */
    public String getEthCoinbase() throws IOException;

    /**
     * 获取当前区块数目
     * */
    public String getBlockNumber() throws IOException;

    /**
     * 判断是否在监听状态
     * */
    public Boolean getNetListening() throws IOException;

    /**
     * 获取连接的节点数
     * */
    public BigInteger getPeerCount() throws IOException;

    /**
     * 判断是否在挖矿状态
     * */
    public Boolean getEthMining() throws IOException;

    /**
     * 获得哈希率
     * */
    public BigInteger getEthHashrate() throws IOException;

    /**
     * 获得汽油价
     * */
    public BigInteger getEthGasPrice() throws IOException;

    /**
     * 获得当前节点的账号
     * */
    public List<String> getEthAccounts() throws IOException;
}
