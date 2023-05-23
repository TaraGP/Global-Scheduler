package org.example.service;

import org.example.DBConnection;
import org.example.model.GSMetrics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



/*GSMetric  variables:Integer scheduleCode, String scheduleDate, assignedTo,scheduleJobDetails */
public class GSMetricsService {
    public static void storeGSMetrics(Integer scheduleCode) throws SQLException {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "Insert into GS_metrics(scheduleCode, scheduleDate, assignedTo, scheduleJobDetails) values(?,?,?,?)";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, scheduleCode);
            LocalDateTime currentDateTime = LocalDateTime.now();
            String scheduleDate = currentDateTime.toString();
            preparedStatement.setString(2, scheduleDate);
            preparedStatement.setString(3, assignedTo);
            preparedStatement.setString(4, scheduleJobDetails);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to store GS metrics in Db:", e);
        }
    }


    public static List<GSMetrics> getGSMetrics() throws SQLException {
        List<GSMetrics> gsMetricsList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "Select * from GS_metrics";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        GSMetrics gsMetrics = new GSMetrics();
                        gsMetrics.setScheduleCode(resultSet.getInt("scheduleCode"));
                        gsMetrics.setScheduleDate(resultSet.getString("scheduleDate"));
                        gsMetrics.setAssignedTo(resultSet.getString("assignedTo"));
                        gsMetrics.setScheduleJobDetails(resultSet.getString("scheduleJobDetails"));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to retrieve schedule data from Db ", e);
            }
            return gsMetricsList;
        }
    }


    public static int getJobDetailsCount(int scheduleCode) throws SQLException {
        int jobDetailsCount = 0;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT COUNT(*) AS jobDetails from GS_metrics where scheduleCode=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, scheduleCode);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        jobDetailsCount = resultSet.getInt("jobDetailsCount");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to retrieve Job details from DB", e);
            }
        }
        return jobDetailsCount;
    }
}

