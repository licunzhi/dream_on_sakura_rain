package com.sakura.irules;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-02
 */
@Configuration
public class MyRukes {

    /**
     * 如果初始化的时候没有对ribbon进行配置
     * 这里我们将默认采用官方代码中给的轮询机制
     * 业务上没有特殊处理的时候确实是无所谓的
     * 但是一旦牵涉到定制化要求这边的代码就需要了
     *
     * new RandomRule()     Ribbon默认是轮询，我自定义为随机
     * new RoundRobinRule() Ribbon默认是轮询，我自定义为随机
     *
     * @return 自定义规则
     */
    @Bean
    public IRule myRule() {
        /*我自定义为每台机器5次*/
        return new RandomRule3Times();
    }
}
