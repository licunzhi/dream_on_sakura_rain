package com.sakura.rain.feign;

import com.sakura.rain.entity.UserInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @ClassName AuthFeignClientCallBack
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/08 16:35
 */
@Component
public class AuthFeignClientCallBack implements FallbackFactory<AuthFeignClient> {


    @Override
    public AuthFeignClient create(Throwable cause) {
        return () -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUser_id("error");
            userInfo.setUser_name("error");
            userInfo.setVersion("error");
            ArrayList<UserInfo> list = new ArrayList<>();
            list.add(userInfo);
            return ResponseEntity.badRequest().body(list);
        };
    }
}
