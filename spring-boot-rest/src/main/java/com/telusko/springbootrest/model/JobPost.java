package com.telusko.springbootrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//we can add these annotation beacuse we have lombok dependencies
//which will handle the getter and setter, constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

}
