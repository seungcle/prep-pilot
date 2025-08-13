package com.example.prep_pilot.dto;

import com.example.prep_pilot.entity.Comment;
import com.example.prep_pilot.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;
    private Long postsId;
    private Long parentId;
    private List<CommentDto> children = new ArrayList<>();
    private String content;
    private Boolean isDeleted;
    private String createdAt;
    private String updatedAt;
    private String nickname;

    public static CommentDto toDto(Comment c) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
        String updatedAtStr = c.getUpdatedAt() != null ? c.getUpdatedAt().format(formatter) : null;

        return new CommentDto(
                c.getId(),
                c.getPosts().getId(),
                c.getParent() != null ? c.getParent().getId() : null,
                new ArrayList<>(),
                c.getContent(),
                c.getIsDeleted(),
                c.getCreatedAt().format(formatter),
                updatedAtStr,
                c.getUser().getNickname()
        );
    }
}
