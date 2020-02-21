package com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.controller;

import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zxf
 * @date 2019/2/26 10:42
 */
@RestController
@RequestMapping(value = "/adminconsumer")
public class AdminManageController {

    @Autowired
    private AdminManageService adminManageService;

    /**
     * 列出账户
     * */
    @RequestMapping(value = "/listaccounts")
    public BaseResult personalListAccounts(){
        BaseResult baseResult = adminManageService.personalListAccounts();
        if (baseResult != null)
            return baseResult;
        return null;
    }

    /**
     * 创建新账户
     * */
    @RequestMapping(value = "/newaccount")
    public BaseResult personalNewAccount(String password){
        BaseResult baseResult = adminManageService.personalNewAccount(password);
        if (baseResult != null)
            return baseResult;
        return null;
    }

    /**
     * 解锁一个账户
     * */
    @RequestMapping(value = "/unlockaccount/{address}/{password}")
    public BaseResult personalUnlockAccount(@PathVariable(value = "address") String address,
                                            @PathVariable(value = "password")String password) throws IOException {
        BaseResult baseResult = adminManageService.personalUnlockAccount(address, password);
        return baseResult;
    }

}
