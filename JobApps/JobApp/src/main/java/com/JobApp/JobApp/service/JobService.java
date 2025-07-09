package com.JobApp.JobApp.service;

import com.JobApp.JobApp.model.JobPost;
import com.JobApp.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    private final JobRepo repo;

    @Autowired
    public JobService(JobRepo repo) {
        this.repo = repo;
    }

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(null);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience with Spring Boot", 2,
                        Arrays.asList("Java", "Spring Boot", "React")),
                new JobPost(2, "Frontend Developer", "Looking for a React.js expert with good UI/UX sense", 1,
                        Arrays.asList("JavaScript", "React", "HTML", "CSS")),
                new JobPost(3, "Python Developer", "Experience with Django and REST APIs required", 3,
                        Arrays.asList("Python", "Django", "REST", "PostgreSQL")),
                new JobPost(4, "DevOps Engineer", "Strong knowledge of CI/CD pipelines and AWS", 4,
                        Arrays.asList("AWS", "Docker", "Jenkins", "Kubernetes")),
                new JobPost(5, "Mobile App Developer", "Develop cross-platform apps using Flutter", 2,
                        Arrays.asList("Flutter", "Dart", "Firebase")),
                new JobPost(6, "Data Analyst", "Hands-on with data visualization tools and SQL", 1,
                        Arrays.asList("SQL", "Tableau", "Power BI", "Excel"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
