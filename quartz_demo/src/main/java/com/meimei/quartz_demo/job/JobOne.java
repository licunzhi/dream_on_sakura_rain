package com.meimei.quartz_demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class JobOne implements Job {

    public void execute(JobExecutionContext context) {
        System.out.println("执行方法。。。。。");
    }
}
