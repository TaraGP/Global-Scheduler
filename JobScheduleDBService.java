package org.example.service;

import org.example.DBConnection;
import org.example.model.JobDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JobScheduleDBService {
    public static void storeJobData(List<JobDetails> jobScheduleResponse){
        try(Connection connection= DBConnection.getConnection()){
            String sql="Insert into jobDetails_table(job_name, job_id, nextRun, job_status, scheduledTime) values(?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (JobDetails JobData : jobScheduleResponse) {
                    statement.setString(1, JobData.getJob_name());
                    statement.setInt(2, JobData.getJob_id());
                    statement.setInt(3, JobData.getNextRun());
                    statement.setString(4, JobData.getJob_status());
                    statement.setTime(5, JobData.getScheduledTime());

                    statement.addBatch();
                }
                statement.executeBatch();
            }
            System.out.println("Job Schedule data stored in the database successfully");
        }
        catch (SQLException e) {
            throw new RuntimeException("Failed to store job schedule data in the DB");
        }
    }
}
