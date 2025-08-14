package com.example.prep_pilot.controller;

import com.example.prep_pilot.dto.CustomUserDetails;
import com.example.prep_pilot.dto.FollowsDto;
import com.example.prep_pilot.service.FollowsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowsController {

    private final FollowsService followsService;

    public FollowsController(FollowsService followsService){

        this.followsService = followsService;
    }

    // 유저아이디가 userId 인 유저 팔로우
    @PostMapping("/{userId}/follows")
    public ResponseEntity<?> postFollows(@AuthenticationPrincipal CustomUserDetails userDetails,
                                         @PathVariable Long userId){

        String username = userDetails.getUsername();
        followsService.postFollows(username, userId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 팔로잉 중인지
    @GetMapping("/{userId}/follows")
    public Boolean isFollowing(@AuthenticationPrincipal CustomUserDetails userDetails,
                               @PathVariable Long userId){

        String username = userDetails.getUsername();

        return followsService.isFollowing(username, userId);
    }

    // primary key가 id인 유저의 팔로워
    @GetMapping("/{id}/followers")
    public ResponseEntity<List<FollowsDto>> showFollowers(@PathVariable Long id){

        List<FollowsDto> followsDtoList = followsService.getFollower(id);

        return ResponseEntity.status(HttpStatus.OK).body(followsDtoList);
    }

    // primary key가 id인 유저의 팔로잉
    @GetMapping("/{id}/followings")
    public ResponseEntity<List<FollowsDto>> showFollowings(@PathVariable Long id){

        List<FollowsDto> followsDtoList = followsService.getFollowings(id);

        return ResponseEntity.status(HttpStatus.OK).body(followsDtoList);
    }

}
