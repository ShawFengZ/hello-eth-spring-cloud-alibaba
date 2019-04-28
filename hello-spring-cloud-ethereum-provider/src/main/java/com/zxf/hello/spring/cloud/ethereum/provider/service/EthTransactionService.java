package com.zxf.hello.spring.cloud.ethereum.provider.service;

import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:23
 */
public interface EthTransactionService {

    /**
     * 通过哈希获取区块内容
     * */
    public EthBlock ethGetBlockByHash(String blockHash) throws IOException;

    /**
     * 通过数字获取区块内容
     * */
    public EthBlock ethGetBlockByNumber(Integer blockNumber) throws IOException;

    /**
     * 通过哈希获取交易
     * */
    public EthTransaction ethGetTransactionByHash(String transactionHash) throws Exception;

    /**
     * 通过区块号获取一个区块中的交易的数目
     * */
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber) throws Exception;

    /**
     * 通过哈希来获取一个区块中的交易的数量
     * */
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash) throws Exception;

    /**
     * 获取交易的接受方
     * */
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash) throws Exception;


    /**
     * 是不是部署的合约？？？
     * */
    public EthGetCode ethGetCode(String address, Integer blockNumber) throws IOException;
}
