package com.zxf.hello.spring.cloud.ethereum.provider.controller;

import com.zxf.hello.spring.cloud.ethereum.provider.service.EthTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author zxf
 * @date 2019/2/25 15:55
 */
@Controller
@ResponseBody
@RequestMapping(value = "/transaction")
public class EthTransactionController {

    @Autowired
    private EthTransactionService ethTransactionService;

    /**
     * 通过哈希获得区块的内容
     * */
    @RequestMapping(value = "/getblockbyhash")
    public EthBlock ethGetBlockByHash(String blockHash) throws IOException {
        if (blockHash != null)
            return ethTransactionService.ethGetBlockByHash(blockHash);
        return null;
    }

    /**
     * 通过序号获取区块信息
     * 451
     * */
    @RequestMapping(value = "/getblockbynumber")
    public EthBlock ethGetBlockByNumber(Integer blockNumber) throws IOException {
        if (blockNumber != null)
            return ethTransactionService.ethGetBlockByNumber(blockNumber);
        return null;
    }

    /**
     * 通过哈希获取交易
     * */
    @RequestMapping(value = "/gettransactionbyhash")
    public EthTransaction ethGetTransactionByHash(String transactionHash) throws Exception {
        if (transactionHash != null) {
            return ethTransactionService.ethGetTransactionByHash(transactionHash);
        }
        return null;
    }

    /**
     * 通过区块号获取一个区块中的交易的数目
     * */
    @RequestMapping(value = "getblocktransactioncountbynumber")
    public BigInteger ethGetBlockTransactionCountByNumber(Integer blockNumber) throws Exception {
        if (blockNumber != null) {
            return ethTransactionService.ethGetBlockTransactionCountByNumber(blockNumber);
        }
        return null;
    }

    /**
     * 通过哈希来获取一个区块中的交易的数量
     * */
    @RequestMapping(value = "getblocktransactioncountbyhash")
    public BigInteger ethGetBlockTransactionCountByHash(String blockHash) throws Exception {
        if (blockHash != null) {
            return ethTransactionService.ethGetBlockTransactionCountByHash(blockHash);
        }
        return null;
    }

    /**
     * 获取交易的接受方
     * */
    @RequestMapping(value = "/gettransactionreceipt")
    public EthGetTransactionReceipt ethGetTransactionReceipt(String transactionHash) throws Exception {
        if (transactionHash != null) {
            return ethTransactionService.ethGetTransactionReceipt(transactionHash);
        }
        return null;
    }

    /**
     * 测试获取某个地址的代码？？
     * */
    @RequestMapping(value = "/getcode")
    public EthGetCode ethGetCode(String address, Integer blockNumber) throws IOException {
        if (address != null && blockNumber != null) {
            return ethTransactionService.ethGetCode(address, blockNumber);
        }
        return null;
    }
}
