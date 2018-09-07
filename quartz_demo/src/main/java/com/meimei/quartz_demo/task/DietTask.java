package com.meimei.quartz_demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author licunzhi
 * @desc 执行任务
 * @date 2018-09-05
 */

@Component // 启动注册为组件，可以自动注入
public class DietTask {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DietTask.class);

    public void notice(){
        LOGGER.info("the diet for test habits!!!");
    }

}
