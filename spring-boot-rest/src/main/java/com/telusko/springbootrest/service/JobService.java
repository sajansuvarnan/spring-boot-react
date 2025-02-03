package com.telusko.springbootrest.service;


import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class JobService {


@Autowired
    private JobRepo repo;

    public void addJob(JobPost jobpost)
    {
        repo.save(jobpost);
    }

    public List<JobPost> getAllJobs()
    {
        return repo.findAll();

    }

    public JobPost getJob(int postId) {

        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void loadData()
    {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1,"JAVA Development","test",2, Collections.singletonList("java")),
                new JobPost(2,"python Development","test",2, Collections.singletonList("python"))
        ));

        repo.saveAll(jobs);
    }
}


/*

//code without connecting database
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

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}
*/
