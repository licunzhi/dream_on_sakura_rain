package com.meimei.quartz_demo.job;

import com.meimei.quartz_demo.service.ServiceDemo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobOne implements Job {

    @Autowired
    private ServiceDemo serviceDemo;

    public void execute(JobExecutionContext context) {
        System.out.println("执行方法servicedemo中的方法");
        serviceDemo.sakura();
        System.out.println("执行方法servicedemo中的方法");
    }
}
