package com.example.prep_pilot.dto;

import com.example.prep_pilot.entity.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewsDto {

    private Long id;
    private Long postsId;
    private Long userId;
    private String createdAt;

    public static ViewsDto toDto(Views views) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");

        return new ViewsDto(
                views.getId(),
                views.getPosts().getId(),
                views.getUser().getId(),
                views.getCreatedAt().format(formatter)
        );
    }
}
