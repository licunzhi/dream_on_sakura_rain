package com.sakura.rain.service;

import com.sakura.rain.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-05
 */
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService> {
    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public User get(long id) {
                return new User().setId(id).setName("没有这个" + id + "对应的信息");
            }

            @Override
            public List<User> list() {
                return null;
            }

            @Override
            public boolean add(User dept) {
                return false;
            }
        };
    }
}
