package com.zxf.hello.spring.cloud.ethereum.consumer.feign.service.fallback;

import com.zxf.hello.spring.cloud.ethereum.consumer.feign.service.EthTransactionService;
import org.springframework.stereotype.Component;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/26 12:43
 */
@Component
public class EthTransactionServiceFallback implements EthTransactionService {

    /**
     * 通过哈希获得区块的内容
     *
     * @param blockHash
     */
    @Override
    public EthBlock ethGetBlockByHash(String blockHash) {
        return null;
    }

    /**
     * 通过序号获取区块信息
     * 451
     *
     * @param blockNumber
     */
    @Override
    public EthBlock ethGetBlockByNumber(Integer blockNumber) {
        return null;
    }

    /**
     * 通过哈希获取交易
     *
     * @param transactionHash
     */
    @Override
    public EthTransaction ethGetTransactionByHash(String transactionHash) {
        return null;
    }

    /**
     * 通过区块号获取一个区块中的交易的数目
     *
     * @param blockNumber
     */
    @Override
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber) {
        return null;
    }

    /**
     * 通过哈希来获取一个区块中的交易的数量
     *
     * @param blockHash
     */
    @Override
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash) {
        return null;
    }

    /**
     * 获取交易的接受方
     *
     * @param transactionHash
     */
    @Override
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash) {
        return null;
    }

    /**
     * 测试获取某个地址的代码？？
     *
     * @param address
     * @param blockNumber
     */
    @Override
    public EthGetCode ethGetCode(String address, Integer blockNumber) {
        return null;
    }
}
