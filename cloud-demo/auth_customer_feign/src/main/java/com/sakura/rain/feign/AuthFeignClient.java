package com.sakura.rain.feign;

import com.sakura.rain.entity.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName AuthFeginClient
 * @function [Feign对业务接口形式的封装]
 * @notice 只需要编写对应的控制层入口的请求接口方式，就能实现调用微服务中其他数据接口的方式
 * @Author lcz
 * @Date 2020/06/08 16:15
 */
@FeignClient(name = "AUTH-SERVICE", fallbackFactory = AuthFeignClientCallBack.class)
public interface AuthFeignClient {

    /**
     * 配置需要调用的微服务接口
     */
    @GetMapping(value = "/user/getUserList")
    ResponseEntity<List<UserInfo>> getUserList();

}
