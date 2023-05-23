package org.example.model;

import java.sql.Time;

public class JobDetails {
    private String job_name;
    private Integer job_id, nextRun;
    private String job_status;
    private Time scheduledTime;
/* String job_name, Integer job_id, nextRun, String job_status, Time scheduledTime     */
    public JobDetails(){}

    public JobDetails(String job_name, Integer job_id, Integer nextRun, String job_status, Time scheduledTime) {
        this.job_name = job_name;
        this.job_id = job_id;
        this.nextRun = nextRun;
        this.job_status = job_status;
        this.scheduledTime = scheduledTime;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getNextRun() {
        return nextRun;
    }

    public void setNextRun(Integer nextRun) {
        this.nextRun = nextRun;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public Time getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Time scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
