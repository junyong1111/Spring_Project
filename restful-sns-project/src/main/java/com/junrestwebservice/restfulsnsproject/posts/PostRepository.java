package com.junrestwebservice.restfulsnsproject.posts;

import com.junrestwebservice.restfulsnsproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {


}
