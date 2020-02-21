package com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.fallback;

import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.ethereum.write.consumer.feign.service.AdminManageService;
import org.springframework.stereotype.Component;

/**
 * @author zxf
 * @date 2019/2/26 10:32
 */
@Component
public class AdminManageServiceFallback implements AdminManageService {

    @Override
    public BaseResult personalListAccounts() {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("get accounts fail with feign error!");
        return baseResult;
    }

    /**
     * 创建一个新账户
     *
     * @param password
     */
    @Override
    public BaseResult personalNewAccount(String password) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("create new account fail with feign error!");
        return baseResult;
    }

    /**
     * 解锁一个账户
     */
    @Override
    public BaseResult personalUnlockAccount(String address, String password) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("unlock account fail with feign error!");
        return baseResult;
    }
}
