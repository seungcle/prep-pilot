package com.example.prep_pilot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikesDto {

    private Long id;
    private Long postsId;
    private Long userId;
    private String createdAt;
}
