package com.telusko.springbootrest.service;


import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {


@Autowired
    private JobRepo repo;

    public void addJob(JobPost jobpost)
    {
        repo.addJob(jobpost);
    }

    public List<JobPost> getAllJobs()
    {
        return repo.getAllJobs();

    }

    public JobPost getJob(int postId) {

        return repo.getJob(postId);
    }
}
