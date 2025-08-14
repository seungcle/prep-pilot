package com.example.prep_pilot.controller;

import com.example.prep_pilot.dto.CustomUserDetails;
import com.example.prep_pilot.dto.PostsDto;
import com.example.prep_pilot.service.PostsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService){

        this. postsService = postsService;
    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostsDto>> getRecentPosts(@RequestParam(defaultValue = "0") int page){

        int pageSize = 12; // 한 페이지에 표시할 게시글 수
        Page<PostsDto> postsPage = postsService.getRecentPosts(page, pageSize);

        return ResponseEntity.status(HttpStatus.OK).body(postsPage);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostsDto> getPost(@PathVariable Long id){

        PostsDto postsDto = postsService.getPost(id);

        return ResponseEntity.status(HttpStatus.OK).body(postsDto);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostsDto> createPost(@AuthenticationPrincipal CustomUserDetails userDetails,
                                               @RequestBody PostsDto dto){

        String username = userDetails.getUsername();
        PostsDto postsDto = postsService.createPost(dto, username);

        return ResponseEntity.status(HttpStatus.CREATED).body(postsDto);
    }

    @PatchMapping("/posts/{id}")
    public ResponseEntity<PostsDto> patchPost(@AuthenticationPrincipal CustomUserDetails userDetails,
                                              @PathVariable Long id,
                                              @RequestBody PostsDto dto){

        String username = userDetails.getUsername();
        PostsDto postsDto = postsService.patchPost(dto, id, username);

        return ResponseEntity.status(HttpStatus.OK).body(postsDto);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<PostsDto> deletePost(@AuthenticationPrincipal CustomUserDetails userDetails,
                                               @PathVariable Long id){

        String username = userDetails.getUsername();
        PostsDto postsDto = postsService.deletePost(id, username);

        return ResponseEntity.status(HttpStatus.OK).body(postsDto);
    }

    // 내가 본 글 목록
    @GetMapping("/posts/read")
    public ResponseEntity<Page<PostsDto>> getMyWatchedPosts(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                            @RequestParam(defaultValue = "0") int page){

        int pageSize = 12;
        String username = userDetails.getUsername();
        Page<PostsDto> dtoPage = postsService.getMyWatchedPosts(page, pageSize, username);

        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }

    // 내가 좋아요 누른 글 목록
    @GetMapping("/posts/likes")
    public ResponseEntity<Page<PostsDto>> getMyLikePosts(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                         @RequestParam(defaultValue = "0") int page){

        int pageSize = 12;
        String username = userDetails.getUsername();
        Page<PostsDto> dtoPage = postsService.getMyLikePosts(page, pageSize, username);

        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }
}
