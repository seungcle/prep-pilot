package com.example.prep_pilot.service;

import com.example.prep_pilot.dto.FollowsDto;
import com.example.prep_pilot.entity.Follows;
import com.example.prep_pilot.entity.User;
import com.example.prep_pilot.exception.UserNotFoundException;
import com.example.prep_pilot.repository.FollowsRepository;
import com.example.prep_pilot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FollowsService {

    private final FollowsRepository followsRepository;
    private final UserRepository userRepository;

    public FollowsService(FollowsRepository followsRepository, UserRepository userRepository){

        this.followsRepository = followsRepository;
        this.userRepository = userRepository;
    }

    public void postFollows(String username, Long userId) {

        User following = userRepository.findByUsername(username);
        User followed = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(userId)
        );

        followsRepository.save(new Follows(null, followed, following, LocalDateTime.now()));

    }

    public Boolean isFollowing(String username, Long userId) {

        Optional<Follows> follows = followsRepository.findByFollowerUserIdAndFollowingUserUsername(userId, username);

        return follows.isPresent();
    }
}
