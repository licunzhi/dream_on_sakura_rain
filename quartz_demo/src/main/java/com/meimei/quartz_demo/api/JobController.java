package com.meimei.quartz_demo.api;

import com.meimei.quartz_demo.job.JobOne;
import com.meimei.quartz_demo.job.SampleJob;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author licunzhi
 * @desc 方便调用这里全部操作为get操作
 * @date 2018-09-07
 */
@RestController
@RequestMapping("/job")
public class JobController {

    private static final Log LOGGER = LogFactory.getLog(JobController.class);

    @Autowired
    @Qualifier(value = "Scheduler")
    private Scheduler scheduler;

    //创建一个新的job任务
    @GetMapping("/add/{jobName}")
    public void addJob(@PathVariable(value = "jobName") String jobName) {
        String groupName = "group_one"; //定义job所在组名称
        String cronExpression = "0 * * ? * * *";//执行时间表达式
        try {

            //构建一个新的任务规范，执行特定任务，任务执行的时间
            for (int i= 0 ;i < 2 ; i++) {
                JobDetail jobDetail = JobBuilder
                                .newJob(SampleJob.class).withIdentity(jobName + i, groupName).build();
                //执行的任务中传入参数
                jobDetail.getJobDataMap().put("sakura", jobName + i);
                //创建corn表达式，创建执行任务的时间规范
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

                //创建一个触发器，加入上面创建的时间规范
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName + i, groupName)
                                .withSchedule(scheduleBuilder).build();

                //把执行的job任务和创建时间trigger绑定一起
                scheduler.scheduleJob(jobDetail, trigger);
            }

            //启动任务调度器，准备添加任务相关信息操作
            scheduler.start();
        } catch (SchedulerException e) {
            LOGGER.info("scheduler start or shutdown error ...");
        }

    }

    //查询所有的任务
    @GetMapping("/search")
    public String searchJob() throws SchedulerException {
        String groupName = "group_one"; //定义job所在组名称
        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));
        StringBuilder message = new StringBuilder();
        for (JobKey jobKey : jobKeys) {
            message.append(jobKey.getName() + "----------------" + jobKey.getGroup() + "\n");
        }
        return message.toString();
    }

    @GetMapping("/pause/{jobName}")
    public String pauseJob(@PathVariable(value = "jobName") String jobName) throws SchedulerException {
        String groupName = "group_one"; //定义job所在组名称
        scheduler.pauseJob(JobKey.jobKey(jobName, groupName));
        return "success";
    }

    @GetMapping("/recover/{jobName}")
    public String recoverJob(@PathVariable(value = "jobName") String jobName) throws SchedulerException {
        String groupName = "group_one"; //定义job所在组名称
        scheduler.resumeJob(JobKey.jobKey(jobName, groupName));
        return "success";
    }

    @GetMapping("/delete/{jobName}")
    public String deleteJob(@PathVariable(value = "jobName") String jobName) throws SchedulerException {
        String groupName = "group_one"; //定义job所在组名称
        scheduler.deleteJob(JobKey.jobKey(jobName, groupName));
        return "success";
    }

    @GetMapping("/update/{jobName}")
    public String updateJob(@PathVariable(value = "jobName") String jobName) throws SchedulerException {
        String groupName = "group_one"; //定义job所在组名称
        String cronExpression = "* * * ? * * *";//执行时间表达式
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);

            //创建corn表达式，创建执行任务的时间规范
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            //获取trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            //把执行的job任务和创建时间trigger绑定一起
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            LOGGER.info("scheduler start or shutdown error ...");
        }

        return "success";

    }


    //创建一个新的jobOne任务
    @GetMapping("/add/jobone/{jobName}")
    public void addJobOne(@PathVariable(value = "jobName") String jobName) {
        String groupName = "group_one"; //定义job所在组名称
        String cronExpression = "0 * * ? * * *";//执行时间表达式
        try {
            //启动任务调度器，准备添加任务相关信息操作
            scheduler.start();

            //构建一个新的任务规范，执行特定任务，任务执行的时间
            JobDetail jobDetail = JobBuilder
                            .newJob(JobOne.class).withIdentity(jobName, groupName).build();
            //执行的任务中传入参数
            jobDetail.getJobDataMap().put("sakura", "sakura");
            //创建corn表达式，创建执行任务的时间规范
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            //创建一个触发器，加入上面创建的时间规范
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, groupName)
                            .withSchedule(scheduleBuilder).build();

            //把执行的job任务和创建时间trigger绑定一起
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            LOGGER.info("scheduler start or shutdown error ...");
        }

    }
}
