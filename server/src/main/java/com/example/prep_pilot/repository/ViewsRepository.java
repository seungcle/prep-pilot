package com.example.prep_pilot.repository;

import com.example.prep_pilot.entity.Posts;
import com.example.prep_pilot.entity.Views;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ViewsRepository extends JpaRepository<Views, Long> {

    Optional<Views> findByPostsIdAndUserUsername(Long postsId, String username);

    @Query("SELECT v.posts FROM Views v WHERE v.user.username = :username ORDER BY v.createdAt DESC")
    Page<Posts> findPostsByUserUsernameOrderByCreatedAtDesc(String username, Pageable pageable);
}
