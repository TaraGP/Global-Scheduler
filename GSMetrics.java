package org.example.model;

public class GSMetrics {
    private Integer scheduleCode;
    private String scheduleDate;
    private String assignedTo;
    private String scheduleJobDetails;
/*GSMetric  variables:Integer scheduleCode, String scheduleDate, assignedTo,scheduleJobDetails */
    public GSMetrics(Integer scheduleCode, String scheduleDate, String assignedTo, String scheduleJobDetails) {
        this.scheduleCode = scheduleCode;
        this.scheduleDate = scheduleDate;
        this.assignedTo = assignedTo;
        this.scheduleJobDetails = scheduleJobDetails;
    }
    public GSMetrics(){}

    public Integer getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(Integer scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getScheduleJobDetails() {
        return scheduleJobDetails;
    }

    public void setScheduleJobDetails(String scheduleJobDetails) {
        this.scheduleJobDetails = scheduleJobDetails;
    }
}
