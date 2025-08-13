package com.example.prep_pilot.dto;

import com.example.prep_pilot.entity.Follows;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowsDto {

    private Long id;
    private String profileImageUrl;
    private String nickname;
    private String username;
    private String bio;

    public static FollowsDto getFollowers(Follows follows){
        return new FollowsDto(
                follows.getId(),
                follows.getFollowingUser().getProfileImageUrl(),
                follows.getFollowingUser().getNickname(),
                follows.getFollowingUser().getUsername(),
                follows.getFollowingUser().getBio()
        );
    }

    public static FollowsDto getFollowings(Follows follows){
        return new FollowsDto(
                follows.getId(),
                follows.getFollowerUser().getProfileImageUrl(),
                follows.getFollowerUser().getNickname(),
                follows.getFollowerUser().getUsername(),
                follows.getFollowerUser().getBio()
        );
    }
}

