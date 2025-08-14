package com.example.prep_pilot.repository;

import com.example.prep_pilot.entity.Likes;
import com.example.prep_pilot.entity.Posts;
import com.example.prep_pilot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    Long countByPostsId(Long postsId);

    Optional<Likes> findByPostsAndUser(Posts posts, User user);

    @Query("SELECT v.posts FROM Likes v WHERE v.user.username = :username ORDER BY v.createdAt DESC")
    Page<Posts> findPostsByUserUsernameOrderByCreatedAtDesc(String username, Pageable pageable);
}
