package com.zxf.hello.spring.cloud.eth.read.consumer.feign.service;
import com.zxf.hello.spring.cloud.eth.read.consumer.feign.common.BaseResult;
import com.zxf.hello.spring.cloud.eth.read.consumer.feign.service.fallback.AdminManageServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zxf
 * @date 2019/2/26 10:31
 */
@Service
@FeignClient(value = "ethereum-provider", fallback = AdminManageServiceFallback.class)
public interface AdminManageService {

    /**
     * 列出所有账户
     * */
    @RequestMapping(value = "/admin/listaccounts")
    public BaseResult personalListAccounts();

    /**
     * 创建一个新账户
     * */
    @RequestMapping(value = "/admin/newaccount")
    public BaseResult personalNewAccount(String password);

    /**
     * 解锁一个账户
     * */
    @RequestMapping(value = "/admin/unlockaccount/{address}/{password}")
    public BaseResult personalUnlockAccount(@PathVariable(value = "address") String address,
                                            @PathVariable(value = "password") String password);


}
