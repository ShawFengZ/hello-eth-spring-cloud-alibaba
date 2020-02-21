package com.zxf.hello.spring.cloud.eth.read.consumer.feign.service;

import com.zxf.hello.spring.cloud.eth.read.consumer.feign.service.fallback.EthTransactionServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/26 12:41
 */
@Service
@FeignClient(value = "ethereum-provider", fallback = EthTransactionServiceFallback.class)
public interface EthTransactionService {

    /**
     * 通过哈希获得区块的内容
     * */
    @RequestMapping(value = "/transaction/getblockbyhash")
    public EthBlock ethGetBlockByHash(String blockHash);

    /**
     * 通过序号获取区块信息
     * 451
     * */
    @RequestMapping(value = "/transaction/getblockbynumber")
    public EthBlock ethGetBlockByNumber(Integer blockNumber);

    /**
     * 通过哈希获取交易
     * */
    @RequestMapping(value = "/transaction/gettransactionbyhash")
    public EthTransaction ethGetTransactionByHash(String transactionHash);

    /**
     * 通过区块号获取一个区块中的交易的数目
     * */
    @RequestMapping(value = "/transaction/getblocktransactioncountbynumber")
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber);

    /**
     * 通过哈希来获取一个区块中的交易的数量
     * */
    @RequestMapping(value = "/transaction/getblocktransactioncountbyhash")
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash);

    /**
     * 获取交易的接受方
     * */
    @RequestMapping(value = "/transaction/gettransactionreceipt")
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash);

}
