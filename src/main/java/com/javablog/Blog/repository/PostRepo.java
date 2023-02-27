package com.javablog.Blog.repository;


import com.javablog.Blog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<PostModel, String> {
}