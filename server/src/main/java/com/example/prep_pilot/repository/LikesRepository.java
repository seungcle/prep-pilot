package com.example.prep_pilot.repository;

import com.example.prep_pilot.entity.Likes;
import com.example.prep_pilot.entity.Posts;
import com.example.prep_pilot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    Long countByPostsId(Long postsId);

    Optional<Likes> findByPostsAndUser(Posts posts, User user);
}
