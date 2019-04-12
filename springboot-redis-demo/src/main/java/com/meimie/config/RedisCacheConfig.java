package com.meimie.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @ClassName RedisCacheConfig
 * @Description Redis的缓存管理器
 * @Author lcz
 * @Date 2019/04/01 14:18
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    // 设置缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //设置缓存过期时间
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(5)))
                .transactionAware()
                .build();
    }

    /**
     * 设置序列化工具
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        /*
        * 关于序列化的配置
        * Performs automatic serialization/deserialization between the given objects and the underlying binary data in the
        * Redis store. By default, it uses Java serialization for its objects (through {@link JdkSerializationRedisSerializer}
        * ). For String intensive operations consider the dedicated {@link StringRedisTemplate}.
        *
        * RedisTemplate默认使用的JdkSerializationRedisSerializer
        * String使用的是StringRedisSerializer
        *
        * 序列化造成传输和接收的数据都是字节,因此使用自定义配置的序列化方式
        * */
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        @SuppressWarnings({ "rawtypes", "unchecked" })
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }

    /**
     * 配置缓存key的生成策略
     * @return
     */
    @Bean
    public KeyGenerator basekeyGenerator() {
        return (target, method, params) -> {
            // 规定 本类名+方法名+参数名 为key
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName()).append("_");
            sb.append(method.getName() + "_");
            for (Object obj : params) {
                sb.append(obj.toString() + ",");
            }
            System.out.println("------------------" + sb.toString() + "------------------");
            return sb.toString();
        };
    }

}
