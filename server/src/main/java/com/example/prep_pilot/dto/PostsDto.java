package com.example.prep_pilot.dto;

import com.example.prep_pilot.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsDto {

    private Long id;

    private String title;

    private String content;

    private String slug;

    private Boolean isPrivate;

    private String createdAt;

    private String updatedAt;

    private String nickname;

    private Long commentCounts;

    private Long likesCounts;

    public static PostsDto toDto(Posts posts) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
        String updatedAtStr = posts.getUpdatedAt() != null ? posts.getUpdatedAt().format(formatter) : null;

        return new PostsDto(
                posts.getId(),
                posts.getTitle(),
                posts.getContent(),
                posts.getSlug(),
                posts.getIsPrivate(),
                posts.getCreatedAt().format(formatter),
                updatedAtStr,
                posts.getUser().getNickname(),
                0L,
                0L
        );
    }
}
