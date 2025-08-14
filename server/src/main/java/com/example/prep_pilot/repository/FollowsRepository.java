package com.example.prep_pilot.repository;

import com.example.prep_pilot.entity.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowsRepository extends JpaRepository<Follows, Long> {

    Optional<Follows> findByFollowerUserIdAndFollowingUserUsername(Long followerUserId, String followingUserUsername);

    List<Follows> findByFollowerUserId(Long followerUserId);

    List<Follows> findByFollowingUserId(Long followingUserId);
}
