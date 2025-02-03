package com.telusko.springbootrest.repo;

import com.telusko.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JobRepo {


    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1,"JAVA Development","test",2, Collections.singletonList("java")),
            new JobPost(2,"python Development","test",2, Collections.singletonList("python"))
    ));


    public List<JobPost> getAllJobs()
    {
        return jobs;

    }

    public void addJob(JobPost job)
    {
        jobs.add(job);
        System.out.println(jobs);
    }


    public JobPost getJob(int postId) {

        for(JobPost job: jobs)
        {
            if(job.getPostId()==postId)
            {
                //System.out.println("reached");
                //System.out.println(job);
                return job;
            }
        }
        //System.out.println("not reached");
        return null;

    }

    public void updateJob(JobPost jobPost) {

        for(JobPost jobPost2: jobs)

            if(jobPost.getPostId() == jobPost2.getPostId())
            {
                jobPost2.setPostProfile(jobPost.getPostProfile());
                jobPost2.setPostDesc(jobPost.getPostDesc());
                jobPost2.setPostTechStack(jobPost.getPostTechStack());
                jobPost2.setReqExperience(jobPost.getReqExperience());
            }

    }

    public void deleteJob(int postId) {

        Iterator<JobPost> iterator = jobs.iterator();
        while(iterator.hasNext())
        {
            JobPost jobPost = iterator.next();

            if(jobPost.getPostId() ==postId)
            {
              iterator.remove();
              break;
            }

        }
    }
}
