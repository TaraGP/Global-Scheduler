package org.example.service;

import org.example.DBConnection;
import org.example.model.JobDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*File jobData, int jobCode, String jobDescription, jobSchedule*/
/* String job_name, Integer job_id, nextRun, String job_status, Time scheduledTime     */
public class JobScheduleGetService {
    public static JobDetails getJobData(int jobCode,String jobDescription, String jobSchedule) throws SQLException{
      JobDetails jobDetails=null;
      try(Connection connection= DBConnection.getConnection()){
          String sql="Select * from jobDetails_table where jobCode=?";
          try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
              preparedStatement.setInt(1, jobCode);
              try(ResultSet resultSet=preparedStatement.executeQuery()){
                  if(resultSet.next()){
                      jobDetails =new JobDetails();
                      jobDetails.setJob_name(resultSet.getString("job_name"));
                      jobDetails.setJob_id(resultSet.getInt("job_id"));
                      jobDetails.setNextRun(resultSet.getInt("nextRun"));
                      jobDetails.setJob_status(resultSet.getString("job_status"));
                      jobDetails.setScheduledTime(resultSet.getTime("scheduledTime"));
                  }
              }
          }
      }catch (SQLException e) {
          throw new RuntimeException("Failed to retrieve error data from the database", e);
      }
     return jobDetails;
    }
}
