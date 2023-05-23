package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.JobDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobScheduleSetService {
    public static List<JobDetails> setJobDetails(File jobData){
        List<JobDetails> jobResponse=new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader(jobData))){
            String line;
            while ((line=reader.readLine())!=null){
                ObjectMapper mapper=new ObjectMapper();
                JobDetails jobDetails=mapper.readValue(line, JobDetails.class);
                jobResponse.add(jobDetails);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        JobScheduleDBService.storeJobData(jobResponse);
        return jobResponse;
    }
}
