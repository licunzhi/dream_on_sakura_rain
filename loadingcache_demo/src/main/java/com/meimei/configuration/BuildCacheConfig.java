package com.meimei.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-25
 */
@Configuration
public class BuildCacheConfig {

    @Bean
    public LoadingCache<String, String> dataCacheStorage() {
        return CacheBuilder.newBuilder().maximumSize(30000000).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("该值在缓存中不存在，进行预加载。。。。。" + key);
                String result = key + UUID.randomUUID().toString();
                return result;
            }
        });
    }

}
