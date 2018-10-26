package com.meimei.quartz_demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-16
 */
@Component
public class CountJob implements Job {

    @Autowired
    @Qualifier(value = "Scheduler")
    private Scheduler scheduler;

    @Override
    public void execute(JobExecutionContext context) {
        int count = context.getJobDetail().getJobDataMap().getInt("count");

        if (count < 30) {
            System.out.println("执行次数：" + count);
            count++;
            context.getJobDetail().getJobDataMap().put("count", count);
            try {
                scheduler.addJob(context.getJobDetail(), true, true);
            } catch (SchedulerException e) {
                System.out.println("刷新数据失败了");
            }
        } else {
            try {
                scheduler.deleteJob(context.getJobDetail().getKey());
            } catch (SchedulerException e) {
                System.out.println("remove job error...");
            }
        }
    }
}
