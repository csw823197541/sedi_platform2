package com.sedi.entity;

/**
 * Created by csw on 2016/12/12 15:32.
 * Explain:
 */
public class ScheduleJobEntity {

    private Integer id;
    private String jobName;//任务名称
    private String jobGroup;//任务分组
    private String jobStatus;//任务状态 0禁用 1启用 2删除
    private String cronExpression;//任务运行时间表达式
    private String notes;

    public ScheduleJobEntity() {}

    public ScheduleJobEntity(String jobName, String jobGroup, String jobStatus, String cronExpression) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.jobStatus = jobStatus;
        this.cronExpression = cronExpression;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
