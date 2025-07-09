package com.JobApp.JobApp.repo;
import com.JobApp.JobApp.model.JobPost;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends MongoRepository<JobPost, Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
