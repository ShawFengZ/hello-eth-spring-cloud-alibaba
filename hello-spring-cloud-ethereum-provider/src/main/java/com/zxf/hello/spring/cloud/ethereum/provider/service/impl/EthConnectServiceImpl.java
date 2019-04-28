package com.zxf.hello.spring.cloud.ethereum.provider.service.impl;

import com.zxf.hello.spring.cloud.ethereum.provider.service.EthConnectService;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zxf
 * @date 2019/2/25 15:21
 */
@Service
public class EthConnectServiceImpl implements EthConnectService {
    /**
     * 与目标geth取得联系
     * */
    Web3j web3j = Web3j.build(new HttpService("http:192.168.198.140:8545"));

    @Override
    public BigInteger getBalance(String address) throws IOException {
        EthGetBalance ethGetBalance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        if (ethGetBalance != null)
            return ethGetBalance.getBalance();
        return null;
    }

    @Override
    public String getEthCoinbase() throws IOException {
        EthCoinbase ethCoinbase = web3j.ethCoinbase().send();
        if (ethCoinbase != null)
            return ethCoinbase.getAddress();
        else
            return null;
    }

    @Override
    public String getBlockNumber() throws IOException {
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().send();
        if (ethBlockNumber != null)
            return ethBlockNumber.getBlockNumber().toString();
        else
            return null;
    }

    @Override
    public Boolean getNetListening() throws IOException {
        NetListening netListening = web3j.netListening().send();
        if (netListening != null)
            return netListening.isListening();
        return null;
    }

    @Override
    public BigInteger getPeerCount() throws IOException {
        NetPeerCount netPeerCount = web3j.netPeerCount().send();
        if (netPeerCount != null)
            return netPeerCount.getQuantity();
        return null;
    }

    @Override
    public Boolean getEthMining() throws IOException {
        EthMining ethMining = web3j.ethMining().send();
        if (ethMining != null)
            return ethMining.isMining();
        return null;
    }

    @Override
    public BigInteger getEthHashrate() throws IOException {
        EthHashrate ethHashrate = web3j.ethHashrate().send();
        if (ethHashrate != null)
            return ethHashrate.getHashrate();
        else
            return null;
    }

    @Override
    public BigInteger getEthGasPrice() throws IOException {
        EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
        if (ethGasPrice != null)
            return ethGasPrice.getGasPrice();
        else
            return null;
    }

    @Override
    public List<String> getEthAccounts() throws IOException {
        EthAccounts ethAccounts = web3j.ethAccounts().send();
        if (ethAccounts != null)
            return ethAccounts.getAccounts();
        else
            return null;
    }
}
