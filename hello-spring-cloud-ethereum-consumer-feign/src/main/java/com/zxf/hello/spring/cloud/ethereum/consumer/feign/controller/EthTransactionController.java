package com.zxf.hello.spring.cloud.ethereum.consumer.feign.controller;

import com.zxf.hello.spring.cloud.ethereum.consumer.feign.service.EthTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/27 9:50
 */
@RestController
@RequestMapping(value = "/transactionconsumer")
public class EthTransactionController {

    @Autowired
    private EthTransactionService ethTransactionService;

    /**
     * 通过哈希获得区块的内容
     * */
    @RequestMapping(value = "/getblockbyhash")
    public EthBlock ethGetBlockByHash(String blockHash) {
        EthBlock ethBlock = ethTransactionService.ethGetBlockByHash(blockHash);
        return ethBlock;
    }

    /**
     * 通过序号获取区块信息
     * 451
     * */
    @RequestMapping(value = "/getblockbynumber")
    public EthBlock ethGetBlockByNumber(Integer blockNumber) {
        EthBlock ethBlock = ethTransactionService.ethGetBlockByNumber(blockNumber);
        return ethBlock;
    }

    /**
     * 通过哈希获取交易
     * */
    @RequestMapping(value = "/gettransactionbyhash")
    public EthTransaction ethGetTransactionByHash(String transactionHash) {
        EthTransaction ethTransaction = ethTransactionService.ethGetTransactionByHash(transactionHash);
        return ethTransaction;
    }

    /**
     * 通过区块号获取一个区块中的交易的数目
     * */
    @RequestMapping(value = "getblocktransactioncountbynumber")
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber) {
        BigInteger bigInteger = ethTransactionService.ethGetBlockTransactionCountByNumber(blockNumber);
        return bigInteger;
    }

    /**
     * 通过哈希来获取一个区块中的交易的数量
     * */
    @RequestMapping(value = "getblocktransactioncountbyhash")
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash) {
        BigInteger bigInteger = ethTransactionService.ethGetBlockTransactionCountByHash(blockHash);
        return bigInteger;
    }

    /**
     * 获取交易的接受方
     * */
    @RequestMapping(value = "/gettransactionreceipt")
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash) {
        EthGetTransactionReceipt ethGetTransactionReceipt = ethTransactionService.ethGetTransactionReceipt(transactionHash);
        return ethGetTransactionReceipt;
    }

    /**
     * 测试获取某个地址的代码？？
     * */
    @RequestMapping(value = "/getcode")
    public EthGetCode ethGetCode(String address, Integer blockNumber) {
        EthGetCode ethGetCode = ethTransactionService.ethGetCode(address, blockNumber);
        return ethGetCode;
    }
}
