package com.meimei.quartz_demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

    @Autowired
    @Qualifier(value = "Scheduler")
    private Scheduler scheduler;

    public SampleJob() {
    }

    public void execute(JobExecutionContext context) {
        String id = context.getJobDetail().getJobDataMap().get("sakura").toString();
        id = id + ">";
        System.out.println("执行方法。。。。。" + id);
        context.getJobDetail().getJobDataMap().put("sakura", id);
        try {
            scheduler.addJob(context.getJobDetail(), true, true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
