package com.meimei.quartz_demo.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author licunzhi
 * @desc 自定义工厂类
 * @date 2018-09-09
 */
@Component
public class SchedulerFactory extends AdaptableJobFactory {

    //spring bean 对象管理工厂
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //自动注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
