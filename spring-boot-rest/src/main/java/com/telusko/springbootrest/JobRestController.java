package com.telusko.springbootrest;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //it only shows the output in json
    @GetMapping(path = "jobPost/{postId}", produces = {"application/json"})
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }

    //we can update it to xml as well
    @PostMapping(path= "jobPost", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);

        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId)
    {
        service.deleteJob(postId);
        return "Data Has been deleted";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
        return service.search(keyword);
    }

    @GetMapping("load")
    public String loadData()
    {
        service.loadData();
        return "Success";
    }
}
