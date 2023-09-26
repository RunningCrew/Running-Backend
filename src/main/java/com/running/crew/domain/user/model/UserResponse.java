package com.running.crew.domain.user.model;


import com.running.crew.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String email;
    private String profileImage;
    private String nickname;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .profileImage(user.getProfileImage())
                .build();
    }
}
