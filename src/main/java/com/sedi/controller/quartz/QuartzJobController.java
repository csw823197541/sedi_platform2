package com.sedi.controller.quartz;

import com.sedi.controller.BaseController;
import com.sedi.entity.ScheduleJobEntity;
import com.sedi.model.ResultModel;
import com.sedi.quartz.QuartzJobFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by csw on 2016/12/12 15:53.
 * Explain:
 */
@RestController
@RequestMapping("/api/quartz")
public class QuartzJobController extends BaseController{

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultModel updateQuartz(@PathVariable(required = true) Integer id,
                                    @RequestBody ScheduleJobEntity job) {

//        job = new ScheduleJobEntity("getMT0102", "get", "1", "0/5 * * * * ?");

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(job.getJobName(), job.getJobGroup())
                        .build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(job.getJobName(), job.getJobGroup())
                        .withSchedule(cronScheduleBuilder)
                        .build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                trigger = trigger.getTriggerBuilder()
                        .withIdentity(triggerKey)
                        .withSchedule(cronScheduleBuilder)
                        .build();
                scheduler.scheduleJob(trigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        ResultModel resultModel = new ResultModel("修改成功");
        return resultModel;
    }







}
