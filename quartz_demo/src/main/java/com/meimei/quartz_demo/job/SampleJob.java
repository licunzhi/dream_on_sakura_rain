package com.meimei.quartz_demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SampleJob implements Job {

    public SampleJob() {
    }

    public void execute(JobExecutionContext context) {
        String id = context.getJobDetail().getJobDataMap().get("sakura").toString();
        System.out.println("执行方法。。。。。" + id);
    }
}
