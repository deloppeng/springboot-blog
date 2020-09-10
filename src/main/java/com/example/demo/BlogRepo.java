package com.example.demo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepo extends MongoRepository<Blog, String> {
    
    public Optional<Blog> findByTitle(String title);       

}
