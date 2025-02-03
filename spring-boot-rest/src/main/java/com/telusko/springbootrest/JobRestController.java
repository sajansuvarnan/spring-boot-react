package com.telusko.springbootrest;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody this is not required as we mention it as restcontroller
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
    }
}
