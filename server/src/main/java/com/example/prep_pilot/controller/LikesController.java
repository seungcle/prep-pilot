package com.example.prep_pilot.controller;

import com.example.prep_pilot.dto.CustomUserDetails;
import com.example.prep_pilot.service.LikesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikesController {

    private final LikesService likesService;

    public LikesController(LikesService likesService){

        this.likesService = likesService;
    }

    // 해당 id 포스트 좋아요 개수
    @GetMapping("/{postsId}/likes")
    public ResponseEntity<Long> getLikesNum(@PathVariable Long postsId){

        Long likesNum = likesService.getLikesNum(postsId);

        return ResponseEntity.status(HttpStatus.OK).body(likesNum);
    }

    @PostMapping("/{postsId}/likes")
    public ResponseEntity<Long> pushLikes(@AuthenticationPrincipal CustomUserDetails userDetails,
                                          @PathVariable Long postsId){

        String username = userDetails.getUsername();
        Long likesNum = likesService.pushLikes(username, postsId);

        return ResponseEntity.status(HttpStatus.OK).body(likesNum);
    }
}
