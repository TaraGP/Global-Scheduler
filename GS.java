package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.example.model.JobDetails;
import org.example.service.GSMetricsService;
import org.example.service.JobScheduleDBService;
import org.example.service.JobScheduleGetService;
import org.example.service.JobScheduleSetService;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

@Mojo(name="GS", requiresProject = false, requiresDependencyResolution = ResolutionScope.NONE )
public class GS  extends AbstractMojo {
    @Parameter(property = "jobData", defaultValue = " ")
    private File jobData;

    @Parameter(property = "jobCode", defaultValue = "")
    private int jobCode;

    @Parameter(property ="jobDescription", defaultValue = " ")
    private String jobDescription;

    @Parameter(property = "jobSchedule",  defaultValue = " ")
    private String jobSchedule;

/*File jobData, int jobCode, String jobDescription, jobSchedule*/


    public void execute() throws MojoExecutionException, MojoFailureException {
        if(jobData ==null || !jobData.isFile()){
            throw new MojoExecutionException("Invalid file provided");
        }
        List<JobDetails> jobResponse= JobScheduleSetService.setJobDetails(jobData);
        JobScheduleDBService.storeJobData(jobResponse);
        try{
          JobScheduleGetService.getJobData(jobCode, jobDescription,jobSchedule);
            GSMetricsService.getJobDetailsCount(jobCode);
            GSMetricsService.getGSMetrics();
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
