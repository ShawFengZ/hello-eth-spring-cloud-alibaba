package com.zxf.hello.spring.cloud.ethereum.provider.service.impl;

import com.zxf.hello.spring.cloud.ethereum.provider.service.EthTransactionService;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:26
 */
@Service
public class EthTransactionServiceImpl implements EthTransactionService {

    /**
     * 与目标geth取得联系
     * */
    Web3j web3j = Web3j.build(new HttpService("http:192.168.198.141:8545"));

    /**
     * 通过哈希获取区块内容
     *
     * @param blockHash
     */
    @Override
    public EthBlock ethGetBlockByHash(String blockHash) throws IOException {
        return web3j.ethGetBlockByHash(blockHash, true).send();
    }

    /**
     * 通过数字获取区块内容
     */
    @Override
    public EthBlock ethGetBlockByNumber(Integer blockNumber) throws IOException {
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNumber);
        return web3j.ethGetBlockByNumber(defaultBlockParameterNumber, true).send();
    }

    /**
     * 通过哈希获取交易
     *
     * @param transactionHash
     */
    @Override
    public EthTransaction ethGetTransactionByHash(String transactionHash) throws Exception {
        return web3j.ethGetTransactionByHash(transactionHash).send();
    }

    /**
     * 通过区块号获取一个区块中的交易的数目
     *
     * @param blockNumber
     */
    @Override
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber) throws Exception {
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNumber);
        return web3j.ethGetBlockTransactionCountByNumber(defaultBlockParameterNumber).send().getTransactionCount();
    }

    /**
     * 通过哈希来获取一个区块中的交易的数量
     *
     * @param blockHash
     */
    @Override
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash) throws Exception {
        return web3j.ethGetBlockTransactionCountByHash(blockHash).send().getTransactionCount();
    }

    /**
     * 获取交易的接受方
     */
    @Override
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash) throws Exception {
        return web3j.ethGetTransactionReceipt(transactionHash).send();
    }

    /**
     * 是不是部署的合约？？？
     */
    @Override
    public EthGetCode ethGetCode(String address, Integer blockNumber) throws IOException {
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(451);
        return web3j.ethGetCode("", defaultBlockParameterNumber).send();
    }
}
